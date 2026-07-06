package com.utility.jpa.repository.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.utility.jpa.repository.BaseJpaRepository;
import com.utility.jpa.request.model.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BaseJpaRepositoryImpl<T> implements BaseJpaRepository<T> {

    private final EntityManager entityManager;

    public BaseJpaRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<T> getSummary(BaseRequest<T> baseRequest) {
        Class<T> tClass = (Class<T>) baseRequest.getEntity().getClass();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(tClass);
        Root<T> root = criteriaQuery.from(tClass);
        entityPredicate(baseRequest.getEntity(), root, criteriaBuilder, criteriaQuery);
        searchCriteria(baseRequest.getSearchCriteria(), root, criteriaBuilder, criteriaQuery);
        sortCriteria(baseRequest.getSortCriteria(), root, criteriaBuilder, criteriaQuery);
        TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(baseRequest.getStartRecord());
        if (baseRequest.getSize() != 0) {
            typedQuery.setMaxResults(baseRequest.getSize());
        }
        return typedQuery.getResultList();
    }

    private static <T> void sortCriteria(SortCriteria sortCriteria, Root<T> root, CriteriaBuilder criteriaBuilder, CriteriaQuery<T> criteriaQuery) {
        Optional.ofNullable(sortCriteria).ifPresent(sCriteria -> {
            Path<Object> objectPath = root.get(sCriteria.getSortColumn());
            Order order = SortOrder.DESC.equals(sCriteria.getSortOrder()) ? criteriaBuilder.desc(objectPath) : criteriaBuilder.asc(objectPath);
            criteriaQuery.orderBy(order);
        });
    }

    private static <T> void searchCriteria(SearchCriteria searchCriteria, Root<T> root, CriteriaBuilder criteriaBuilder, CriteriaQuery<T> criteriaQuery) {
        Optional.ofNullable(searchCriteria).ifPresent(sCriteria -> {
            var searchString = SearchType.PREFIX.equals(sCriteria.getSearchType()) ? sCriteria.getSearchString() + "%" : "%" + sCriteria.getSearchString() + "%";
            var predicates = getColumnsPredicate(root, criteriaBuilder, sCriteria, searchString);
            var predicatesArray = predicates.toArray(new Predicate[]{});
            addSearchOperator(criteriaBuilder, criteriaQuery, sCriteria, predicatesArray);
        });
    }

    private static <T> List<Predicate> getColumnsPredicate(Root<T> root, CriteriaBuilder criteriaBuilder, SearchCriteria sCriteria, String searchString) {
        return sCriteria.getSearchColumns().stream().map(searchColumn -> {
            if (!searchColumn.contains(".")) {
                return criteriaBuilder.like(root.get(searchColumn), searchString);
            }
            Path<String> objectPath = getObjectPath(root, searchColumn);
            return criteriaBuilder.like(objectPath, searchString);
        }).toList();
    }

    private static <T> void entityPredicate(T t, Root<T> root, CriteriaBuilder criteriaBuilder, CriteriaQuery<T> criteriaQuery) {
        var predicates = new ArrayList<Predicate>();
        if (t == null) {
            return;
        }
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.convertValue(t, JsonNode.class);
        Map<String, Object> flattenedMap = flattenJson(rootNode, "");
        flattenedMap.forEach((flattenedColumn, value) -> {
            if (!flattenedColumn.contains(".")) {
                predicates.add(criteriaBuilder.equal(root.get(flattenedColumn), value));
            } else {
                Path<String> objectPath = getObjectPath(root, flattenedColumn);
                predicates.add(criteriaBuilder.equal(objectPath, value));
            }
        });
        var predicatesArray = predicates.toArray(new Predicate[]{});
        criteriaQuery.select(root).where(predicatesArray);
    }

    private static <T> Path<String> getObjectPath(Root<T> root, String column) {
        Path<String> objectPath = null;
        String[] hierarchyFields = column.split("\\.");
        for (String fieldName : hierarchyFields) {
            if (objectPath == null) {
                objectPath = root.get(fieldName);
                continue;
            }
            objectPath = objectPath.get(fieldName);
        }
        return objectPath;
    }

    private static <T> void addSearchOperator(CriteriaBuilder criteriaBuilder, CriteriaQuery<T> criteriaQuery, SearchCriteria sCriteria, Predicate[] predicatesArray) {
        if (SearchOperator.OR.equals(sCriteria.getSearchOperator())) {
            criteriaQuery.where(criteriaBuilder.or(predicatesArray));
        } else {
            criteriaQuery.where(predicatesArray);
        }
    }

    private static Map<String, Object> flattenJson(JsonNode node, String prefix) {
        Map<String, Object> flatMap = new HashMap<>();
        Iterator<Map.Entry<String, JsonNode>> fieldsIterator = node.fields();
        while (fieldsIterator.hasNext()) {
            Map.Entry<String, JsonNode> field = fieldsIterator.next();
            if (field.getValue().isNull()) {
                continue;
            }
            if (field.getValue().isObject()) {
                flatMap.putAll(flattenJson(field.getValue(), prefix + field.getKey() + "."));
            } else if (field.getValue().isBoolean()) {
                flatMap.put(prefix + field.getKey(), field.getValue().booleanValue());
            } else {
                flatMap.put(prefix + field.getKey(), field.getValue().asText());
            }
        }
        return flatMap;
    }
}

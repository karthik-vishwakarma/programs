package com.utility.jpa.request.model;

import lombok.Data;

import java.util.List;
@Data
public class SearchCriteria {
    private String searchString;
    private List<String> searchColumns;
    private SearchOperator searchOperator;
    private SearchType searchType;
}

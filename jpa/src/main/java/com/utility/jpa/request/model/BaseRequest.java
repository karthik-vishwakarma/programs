package com.utility.jpa.request.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BaseRequest<T> {

    private int startRecord;
    private int size;
    private LocalDate startDate;
    private LocalDate endDate;
    private String dateRangeColumn;
    private SearchCriteria searchCriteria;
    private SortCriteria sortCriteria;
    private T entity;
}
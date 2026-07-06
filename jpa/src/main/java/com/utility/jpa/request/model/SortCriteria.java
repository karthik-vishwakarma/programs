package com.utility.jpa.request.model;

import lombok.Data;

@Data
public class SortCriteria {

    private String sortColumn;
    private SortOrder sortOrder;
}
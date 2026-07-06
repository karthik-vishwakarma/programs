package com.utility.jpa.repository;

import com.utility.jpa.request.model.BaseRequest;

import java.util.List;

public interface BaseJpaRepository<T> {

    List<T> getSummary(BaseRequest<T> baseRequest);
}

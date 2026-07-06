package com.utility.jpa.repository;

public interface JpaRepository<T, ID> extends BaseJpaRepository<T>, org.springframework.data.jpa.repository.JpaRepository<T, ID> {

}

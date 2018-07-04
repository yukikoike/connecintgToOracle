package com.example.connectingoracle.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.connectingoracle.domain.model.Employees;

/**
 * 労働者Repository
 */
@Repository
public interface EmployeesRepository extends JpaRepository<Employees, String> {

    /**
     * 全雇用者の情報を取得する
     *
     * @param pageable ?
     * @return ?
     */
    Page<Employees> findAll(Pageable pageable);
}

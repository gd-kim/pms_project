package com.raonse2.pms_project.repository;

import com.raonse2.pms_project.model.Emp;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpRepository extends JpaRepository<Emp, Integer> {
    Emp findByEmpno(int empno);
}


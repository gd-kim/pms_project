package com.raonse2.pms_project.repository;

import com.raonse2.pms_project.model.Engineer_Info;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Engineer_InfoRepository extends JpaRepository<Engineer_Info, Integer> {
    Engineer_Info findByEmpno(int empno);
}


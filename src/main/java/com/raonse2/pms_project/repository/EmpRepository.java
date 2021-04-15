package com.raonse2.pms_project.repository;

import com.raonse2.pms_project.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Emp, String>{
}

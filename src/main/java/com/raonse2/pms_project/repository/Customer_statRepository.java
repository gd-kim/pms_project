package com.raonse2.pms_project.repository;

import com.raonse2.pms_project.model.Customer_stat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Customer_statRepository extends JpaRepository<Customer_stat, Integer> {
    Customer_stat findById(int id);
}


package com.raonse2.pms_project.repository;

import com.raonse2.pms_project.model.Customer_Info;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface Customer_InfoRepository extends JpaRepository<Customer_Info, Integer> {
    Optional<Customer_Info> findByCustomerno(int customer_no);


}


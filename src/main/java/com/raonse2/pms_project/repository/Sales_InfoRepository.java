package com.raonse2.pms_project.repository;

import com.raonse2.pms_project.model.Sales_Info;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface Sales_InfoRepository extends JpaRepository<Sales_Info, Integer> {
    Optional<Sales_Info> findBySalesno(int salesno);


}


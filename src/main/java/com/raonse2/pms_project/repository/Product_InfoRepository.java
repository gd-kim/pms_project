package com.raonse2.pms_project.repository;

import com.raonse2.pms_project.model.Engineer_Info;
import com.raonse2.pms_project.model.Product_Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface Product_InfoRepository extends JpaRepository<Product_Info, Integer> {

    List<Product_Info> findAllByProductStandardNotContaining(String options);


    List<Product_Info> findAllByProductNoContaining(String projectCode);


}


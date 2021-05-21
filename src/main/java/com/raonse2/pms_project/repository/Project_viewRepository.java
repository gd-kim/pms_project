package com.raonse2.pms_project.repository;

import com.raonse2.pms_project.model.Engineer_Info;
import com.raonse2.pms_project.model.Project_viewTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface Project_viewRepository extends JpaRepository<Project_viewTable, String> {
    List<Project_viewTable> findAll();
}


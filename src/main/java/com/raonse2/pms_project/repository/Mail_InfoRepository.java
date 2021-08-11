package com.raonse2.pms_project.repository;

import com.raonse2.pms_project.model.Mail_Info;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Mail_InfoRepository extends JpaRepository<Mail_Info, Integer> {
    List<Mail_Info> findAll();
}

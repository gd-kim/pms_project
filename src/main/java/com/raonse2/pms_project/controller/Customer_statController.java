package com.raonse2.pms_project.controller;

import com.raonse2.pms_project.service.Customer_statService;
import com.raonse2.pms_project.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/Customer_stat")
public class Customer_statController {

    @Autowired
    Customer_statService customer_statService;

}

package com.raonse2.pms_project.controller;

import com.raonse2.pms_project.dto.customer_emp_info.Customer_emp_infoResponseDto;
import com.raonse2.pms_project.querydslRepository.Customer_Emp_InfoRepositorySupport;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1.0/customer-emp-info")
public class CustomerEmpApiController {
    @Autowired
    Customer_Emp_InfoRepositorySupport customerEmpInfoRepositorySupport;
    /*
     *** REST API URL설계 RULES
     1. 마지막에 / 를 포함하지 않는다.
     2. _ 대신 - 를 사용한다.
     3. 소문자를 사용한다.
     4. 행위는 url에 포함하지 않는다. ex) delete, update 등등..
     */

    /**
     * 고객사 번호로 고객사 담당자 정보를 조회한다
     * @param customerNo
     * @return List<Customer_emp_infoResponseDto>
     * @author sjseo
     */
    @GetMapping("/1/customerNo")
    public List<Customer_emp_infoResponseDto> findByCustomerNo (@RequestParam int customerNo){
       return customerEmpInfoRepositorySupport.findByCustomerNo(customerNo);
    }

    @PutMapping("/2/projectCode")
    public void updateCustomerEmpInfo(@RequestBody String requestData) {
        JSONObject data = new JSONObject(requestData);
        String projectCode = (String) data.get("projectCode");
        String customerEmpName = (String) data.get("customerEmpName");
        String customerMailAddress = (String) data.get("customerMailAddress");
        String customerEmpPhone = (String) data.get("customerEmpPhone");

        customerEmpInfoRepositorySupport.updateCustomerEmpInfo(projectCode, customerEmpName, customerMailAddress, customerEmpPhone);
    }
}

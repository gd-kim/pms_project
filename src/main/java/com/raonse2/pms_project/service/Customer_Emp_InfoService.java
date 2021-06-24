package com.raonse2.pms_project.service;

import com.raonse2.pms_project.dto.customer_emp_info.Customer_emp_infoResponseDto;
import com.raonse2.pms_project.repository.Customer_Emp_InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class Customer_Emp_InfoService {
    private final Customer_Emp_InfoRepository customer_emp_infoRepository;


    @Transactional(readOnly = true)
    public List<Customer_emp_infoResponseDto> findByAll() {

        return customer_emp_infoRepository.findAll().stream().map(Customer_emp_infoResponseDto::new).collect(Collectors.toList());
    }

}

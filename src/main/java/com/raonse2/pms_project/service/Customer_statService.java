package com.raonse2.pms_project.service;

import com.raonse2.pms_project.dto.Customer_statResponseDto;
import com.raonse2.pms_project.model.Customer_stat;
import com.raonse2.pms_project.model.Emp;
import com.raonse2.pms_project.repository.Customer_statRepository;
import com.raonse2.pms_project.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class Customer_statService {
    private final Customer_statRepository customer_statRepository;


    @Transactional(readOnly = true)
    public Customer_statResponseDto findById(int id) {
    Customer_stat entity = customer_statRepository.findById(id);

        return new Customer_statResponseDto(entity);
    }

    @Transactional
    public void delete(int id){
        Customer_stat customer_stat = customer_statRepository.findById(id);
        customer_statRepository.delete(customer_stat);
    }

}

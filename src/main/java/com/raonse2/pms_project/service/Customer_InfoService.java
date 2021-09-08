package com.raonse2.pms_project.service;

import com.raonse2.pms_project.dto.customer_info.Customer_infoResponseDto;
import com.raonse2.pms_project.model.Customer_Info;
import com.raonse2.pms_project.repository.Customer_InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class Customer_InfoService {
    private final Customer_InfoRepository customer_InfoRepository;

    @Transactional(readOnly = true)
    public List<Customer_infoResponseDto> findAll() {
        return customer_InfoRepository.findAll().stream().map(Customer_infoResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Customer_infoResponseDto findByCustomer_no(int customer_no) {
        Customer_Info entity = customer_InfoRepository.findByCustomerno(customer_no).orElseThrow(()-> new IllegalArgumentException("해당 사용자는 존재하지 않습니다.. customer_no= "+customer_no));

        return new Customer_infoResponseDto(entity);
    }
}

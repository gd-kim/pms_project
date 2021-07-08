package com.raonse2.pms_project.service;


import com.raonse2.pms_project.dto.product_info.Product_InfoResponseDto;
import com.raonse2.pms_project.repository.Product_InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class Product_InfoService {
    private final Product_InfoRepository product_InfoRepository;

    @Transactional(readOnly = true)
    public List<Product_InfoResponseDto> findAllByProductStandardNotContaining(String options) {
        List<Product_InfoResponseDto> products = product_InfoRepository.findAllByProductStandardNotContaining(options).stream().map(Product_InfoResponseDto::new).collect(Collectors.toList());
        return products;
    }

}

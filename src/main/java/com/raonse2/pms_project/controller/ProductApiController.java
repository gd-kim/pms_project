package com.raonse2.pms_project.controller;

import com.raonse2.pms_project.dto.engineer_info.Engineer_InfoResponseDto;
import com.raonse2.pms_project.dto.engineer_info.Engineer_InfoSaveRequestDto;
import com.raonse2.pms_project.dto.engineer_info.Engineer_InfoUpdateRequestDto;
import com.raonse2.pms_project.dto.product_info.Product_InfoResponseDto;
import com.raonse2.pms_project.model.Product_Info;
import com.raonse2.pms_project.querydslRepository.Product_InfoRepositorySupport;
import com.raonse2.pms_project.service.Engineer_InfoService;
import com.raonse2.pms_project.service.Product_InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1.0/product-info")
public class ProductApiController {

    @Autowired
    Product_InfoService product_infoService;

    @Autowired
    Product_InfoRepositorySupport productInfoRepositorySupport;
    /*
     *** REST API URL설계 RULES
     1. 마지막에 / 를 포함하지 않는다.
     2. _ 대신 - 를 사용한다.
     3. 소문자를 사용한다.
     4. 행위는 url에 포함하지 않는다. ex) delete, update 등등..
     */

    /**
     * @param options
     * 조회한다.
     * @return Product_InfoResponseDto
     * @author gdkim
     */
    @GetMapping("/1/{options}")
    public List<Product_InfoResponseDto> findAllByProductStandardNotContaining (@PathVariable("options") String options){
        return product_infoService.findAllByProductStandardNotContaining(options);
    }

    /**
     * 프로젝트 코드로 품명 리스트를 조회한다
     * @param pjtcode
     * @return List<Product_InfoResponseDto>
     * @author gdkim
     */
    @GetMapping("/2/projectcode")
    public List<Product_InfoResponseDto> findByProductNo (@RequestParam String pjtcode){
        return productInfoRepositorySupport.findByProductNo(pjtcode);
    }


}

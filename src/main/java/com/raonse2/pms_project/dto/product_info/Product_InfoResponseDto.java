package com.raonse2.pms_project.dto.product_info;

import com.raonse2.pms_project.model.Product_Info;
import lombok.Getter;


/**
 * 고유 Entity는 건들면 안됨.
 * 따로 DTO 객체 만들어서 전달.
 */
@Getter
public class Product_InfoResponseDto {

    private int productNo;
    private String productName;
    private int createEmpNo;
    private int updateEmpNo;
    private String productStandard;
    private String productOptions;


    public Product_InfoResponseDto(Product_Info entity){
        this.productNo = entity.getProductNo();
        this.productName = entity.getProductName();
        this.productStandard = entity.getProductStandard();
        this.productOptions = entity.getProductOptions();
    }

}

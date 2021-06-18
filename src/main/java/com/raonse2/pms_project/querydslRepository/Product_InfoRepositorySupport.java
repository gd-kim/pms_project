package com.raonse2.pms_project.querydslRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.raonse2.pms_project.dto.product_info.Product_InfoResponseDto;
import com.raonse2.pms_project.model.Product_Info;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.raonse2.pms_project.model.QProduct_Info.product_Info;
import static com.raonse2.pms_project.model.QProject_Product_Info.project_Product_Info;
@Service
public class Product_InfoRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public Product_InfoRepositorySupport(JPAQueryFactory queryFactory) {
        super(Product_Info.class);
        this.queryFactory = queryFactory;
    }

    //int productNo,String productName, int createEmpNo, int updateEmpNo, String productStandard,String productOptions
    @Transactional(readOnly = true)
    public List<Product_InfoResponseDto> findByProductNo(String productCode) {
        return queryFactory
                .select(Projections.constructor(Product_InfoResponseDto.class,product_Info))
                        .from(product_Info)
                .where(product_Info.productNo.in(
                        JPAExpressions
                                .select(project_Product_Info.productNo)
                                .from(project_Product_Info)
                                .where(project_Product_Info.projectCode.eq(productCode))
                )).fetch();
    }
}


package com.raonse2.pms_project;

import com.raonse2.pms_project.model.Product_Info;
import com.raonse2.pms_project.querydslRepository.Product_InfoRepositorySupport;
import com.raonse2.pms_project.repository.Product_InfoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuerydslTest {
    @Autowired
    private Product_InfoRepository productInfoRepository;

    @Autowired
    private Product_InfoRepositorySupport productInfoRepositorySupport;

    /*@Test
    public void querydsl_기본기능(){
        String projectCode = "PJ2000814";

        List<Product_Info> result = productInfoRepositorySupport.findByProductNo(projectCode);

    }*/


}

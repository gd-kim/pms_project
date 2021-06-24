package com.raonse2.pms_project.querydslRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.raonse2.pms_project.dto.customer_emp_info.Customer_emp_infoResponseDto;
import com.raonse2.pms_project.model.Customer_Emp_Info;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.raonse2.pms_project.model.QCustomer_Emp_Info.customer_Emp_Info;
import static com.raonse2.pms_project.model.QCustomer_Info.customer_Info;

@Service
public class Customer_Emp_InfoRepositorySupport extends QuerydslRepositorySupport {
    private final JPAQueryFactory queryFactory;

    public Customer_Emp_InfoRepositorySupport(JPAQueryFactory queryFactory) {
        super(Customer_Emp_Info.class);
        this.queryFactory = queryFactory;
    }

    //int customer_empno, String customer_emp_name, String customer_mail_address, String customer_emp_phone, int customer_no
    @Transactional(readOnly = true)
    public List<Customer_emp_infoResponseDto> findByCustomerNo(int customerNo) {
        return queryFactory
                .select(Projections.constructor(Customer_emp_infoResponseDto.class, customer_Emp_Info))
                .from(customer_Emp_Info, customer_Info)
                .where(customer_Emp_Info.customer_no.eq(customer_Info.customer_no), customer_Info.customer_no.eq(customerNo))
                .fetch();
    }
}


package com.raonse2.pms_project.querydslRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.raonse2.pms_project.dto.customer_emp_info.Customer_emp_infoResponseDto;
import com.raonse2.pms_project.model.Customer_Emp_Info;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.raonse2.pms_project.model.QCustomer_Emp_Info.customer_Emp_Info;
import static com.raonse2.pms_project.model.QCustomer_Info.customer_Info;
import static com.raonse2.pms_project.model.QProject_Info.project_Info;

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

    /*
     * PROJECT_INFO 테이블의 PROJECT_CODE 값을 가지고
     * CUSTOMER_EMP_INFO 테이블의
     * CUSTOMER_EMP_NAME, CUSTOMER_MAIL_ADDRESS, CUSTOMER_EMP_PHONE 수정
     *
     * update customer_emp_info
     * set customer_emp_name = '이름',
     *     customer_mail_address = '메일주소',
     *     customer_emp_phone = '전화번호'
     * where customer_empno = (select customer_emp_info.customer_empno
     *                         from customer_info, customer_emp_info, project_info
     *                         where project_info.project_code = '프로젝트코드' and
     *                               project_info.customer_no = customer_info.customer_no and
     *                               customer_info.customer_no = customer_emp_info.customer_no)
     */
    @Transactional
    public void updateCustomerEmpInfo(String projectCode,
                                      String customerEmpName,
                                      String customerMailAddress,
                                      String customerEmpPhone) {
        ArrayList columns = new ArrayList();
        columns.add(customer_Emp_Info.customer_emp_name);
        columns.add(customer_Emp_Info.customer_mail_address);
        columns.add(customer_Emp_Info.customer_emp_phone);

        ArrayList params = new ArrayList();
        params.add(customerEmpName);
        params.add(customerMailAddress);
        params.add(customerEmpPhone);

        queryFactory
                .update(customer_Emp_Info)
                .set(columns, params)
                .where(customer_Emp_Info.customer_empno.eq(
                        JPAExpressions
                                .select(customer_Emp_Info.customer_empno)
                                .from(customer_Info, customer_Emp_Info, project_Info)
                                .where(project_Info.project_code.eq(projectCode),
                                        project_Info.customer_no.eq(customer_Emp_Info.customer_no),
                                        customer_Info.customer_no.eq(customer_Emp_Info.customer_no))
                )).execute();
    }
}


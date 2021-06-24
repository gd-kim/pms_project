package com.raonse2.pms_project.dto.customer_emp_info;

import com.raonse2.pms_project.model.Customer_Emp_Info;
import lombok.Getter;

/**
 * 고유 Entity는 건들면 안됨.
 * 따로 DTO 객체 만들어서 전달.
 */
@Getter
public class Customer_emp_infoResponseDto {
    private int customer_empno;
    private String customer_emp_name;
    private String customer_mail_address;
    private String customer_emp_phone;
    private int customer_no;

    public Customer_emp_infoResponseDto(Customer_Emp_Info entity) {
        customer_empno = entity.getCustomer_empno();
        customer_emp_name = entity.getCustomer_emp_name();
        customer_mail_address = entity.getCustomer_mail_address();
        customer_emp_phone = entity.getCustomer_emp_phone();
        customer_no = entity.getCustomer_no();
    }
}

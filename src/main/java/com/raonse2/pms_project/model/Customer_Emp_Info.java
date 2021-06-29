package com.raonse2.pms_project.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER_EMP_INFO")
public class Customer_Emp_Info {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CUSTOMER_EMP_INFONO")
    @SequenceGenerator(name = "SEQ_CUSTOMER_EMP_INFONO", sequenceName = "SEQ_CUSTOMER_EMP_INFONO", allocationSize = 1)
    private int customer_empno;
    private String customer_emp_name;
    private String customer_mail_address;
    private String customer_emp_phone;
    private int customer_no;

    @Builder
    public Customer_Emp_Info(int customer_empno, String customer_emp_name, String customer_mail_address, String customer_emp_phone, int customer_no) {
        this.customer_empno = customer_empno;
        this.customer_emp_name = customer_emp_name;
        this.customer_mail_address = customer_mail_address;
        this.customer_emp_phone = customer_emp_phone;
        this.customer_no = customer_no;
    }
}

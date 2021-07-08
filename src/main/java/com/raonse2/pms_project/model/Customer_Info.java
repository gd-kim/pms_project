package com.raonse2.pms_project.model;

import com.raonse2.pms_project.util.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter                   //lombok
@NoArgsConstructor      //lombok
@Entity
@Table(name = "CUSTOMER_INFO")
public class Customer_Info{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CUSTOMER_EMPNO")
    @SequenceGenerator(name = "SEQ_CUSTOMER_EMPNO", sequenceName = "SEQ_CUSTOMER_EMPNO", allocationSize = 1)
    private int customer_no;
    private String customer_name;
    private String engineer_no;
    private int create_emp_no;
    private int update_emp_no;

    @Builder // 롬복, 빌더 패턴 클래스 생성
    public Customer_Info(String customer_name, String engineer_no, int create_emp_no, int update_emp_no){
        this.customer_name= customer_name;
        this.engineer_no= engineer_no;
        this.create_emp_no= create_emp_no;
        this.update_emp_no= update_emp_no;

    }
    public void update(String customer_name, String engineer_no,int update_emp_no){
        this.customer_name= customer_name;
        this.engineer_no= engineer_no;
        this.update_emp_no= update_emp_no;
    }

}

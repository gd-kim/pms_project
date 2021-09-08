package com.raonse2.pms_project.model;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CUSTOMER_INFO")
    @SequenceGenerator(name = "SEQ_CUSTOMER_INFO", sequenceName = "SEQ_CUSTOMER_INFO", allocationSize = 1)
    @Column(name ="customer_no")
    private int customerno;
    private String customer_name;
    private int engineer_no;

    @Builder // 롬복, 빌더 패턴 클래스 생성
    public Customer_Info(String customer_name, int engineer_no){
        this.customer_name= customer_name;
        this.engineer_no= engineer_no;

    }
    public void update(String customer_name, int engineer_no){
        this.customer_name= customer_name;
        this.engineer_no= engineer_no;
    }

}

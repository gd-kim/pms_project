package com.raonse2.pms_project.model;

import com.raonse2.pms_project.util.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter                   //lombok
@NoArgsConstructor      //lombok
@Entity
@Table(name = "PRODUCT_INFO")
public class Product_Info{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCT_NO")
    @SequenceGenerator(name = "SEQ_PRODUCT_NO", sequenceName = "SEQ_PRODUCT_NO", allocationSize = 1)
    @Column(name ="product_no")
    private int productNo;
    @Column(name ="product_name")
    private String productName;
    /*@Column(name ="create_emp_no")
    private int createEmpNo;
    @Column(name ="update_emp_no")
    private int updateEmpNo;
*/    @Column(name ="product_standard")
    private String productStandard;
    @Column(name ="product_options")
    private String productOptions;

    @Builder // 롬복, 빌더 패턴 클래스 생성
    public Product_Info(String productName,String productStandard, String productOptions){
        this.productName= productName;
        this.productStandard= productStandard;
        this.productOptions= productOptions;

    }


}

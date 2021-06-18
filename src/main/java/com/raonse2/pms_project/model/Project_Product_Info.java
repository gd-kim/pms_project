package com.raonse2.pms_project.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter                   //lombok
@NoArgsConstructor      //lombok
@Entity
@Table(name = "PROJECT_PRODUCT_INFO")
public class Project_Product_Info {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROJECT_PRODUCT_INFO_SEQ")
    @SequenceGenerator(name = "PROJECT_PRODUCT_INFO_SEQ", sequenceName = "PROJECT_PRODUCT_INFO_SEQ", allocationSize = 1)
    @Column(name ="project_product_info_no")
    private int projectProductInfoNo;

    @Column(name ="project_code")
    private String projectCode;

    @Column(name ="product_no")
    private int productNo;

    @Column(name ="product_version")
    private String productVersion;

    @Column(name ="product_option")
    private String productOption;

    @Column(name ="install_type")
    private String installType;

    @Column(name ="memo")
    private String memo;

    @Builder // 롬복, 빌더 패턴 클래스 생성
    public Project_Product_Info(int projectProductInfoNo
            , String projectCode
            , int productNo
            , String productVersion
            , String productOption
            , String installType
            , String memo){
        this.projectProductInfoNo= projectProductInfoNo;
        this.projectCode= projectCode;
        this.productNo= productNo;
        this.productVersion= productVersion;
        this.productOption= productOption;
        this.installType= installType;
        this.memo= memo;

    }

}

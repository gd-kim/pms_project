package com.raonse2.pms_project.dto;

import com.raonse2.pms_project.model.Customer_stat;
import com.raonse2.pms_project.model.Emp;
import com.sun.istack.NotNull;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Date;

/**
 * 고유 Entity는 건들면 안됨.
 * 따로 DTO 객체 만들어서 전달.
 */
@Getter
public class Customer_statResponseDto {

    private int id;
    private String contract_type;
    private Date date_create;
    private String pjt_code;
    private String purchsofc;
    private String pjt_name;
    private String sales_name;
    private String pm;
    private String pm2;
    private String se;
    private Date mntnce_strt_ymd;
    private Date mntnce_expt_ymd;
    private String mntnce_se;
    private String vendor;
    private String cust_name;
    private String cust_phone;
    private String cust_email;
    private String solution_name;
    private String snsdr;
    private int cnt;
    private String url;

    public Customer_statResponseDto(Customer_stat entity){
        this.id = entity.getId();
        this.contract_type = entity.getContract_type();
        this.date_create = entity.getDate_create();
        this.pjt_code = entity.getPjt_code();
        this.purchsofc = entity.getPurchsofc();
        this.pjt_name = entity.getPjt_name();
        this.sales_name = entity.getSales_name();
        this.pm = entity.getPm();
        this.pm2 = entity.getPm2();
        this.se = entity.getSe();
        this.mntnce_strt_ymd = entity.getMntnce_strt_ymd();
        this.mntnce_expt_ymd = entity.getMntnce_expt_ymd();
        this.mntnce_se = entity.getMntnce_se();
        this.vendor = entity.getVendor();
        this.cust_name = entity.getCust_name();
        this.cust_phone = entity.getCust_phone();
        this.cust_email = entity.getCust_email();
        this.solution_name = entity.getSolution_name();
        this.snsdr = entity.getSnsdr();
        this.cnt = entity.getCnt();
        this.url = entity.getUrl();
    }
}

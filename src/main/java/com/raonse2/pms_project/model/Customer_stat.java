package com.raonse2.pms_project.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data                   //lombok
@NoArgsConstructor      //lombok
@AllArgsConstructor     //lombok

@Entity
@Table(name = "CUSTOMER_STAT")
public class Customer_stat {

    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String contract_type;
    @NotNull
    private Date date_create;
    @NotNull
    private String pjt_code;
    @NotNull
    private String purchsofc;
    @NotNull
    private String pjt_name;
    @NotNull
    private String sales_name;
    @NotNull
    private String pm;

    private String pm2;

    @NotNull
    private String se;
    @NotNull
    private Date mntnce_strt_ymd;
    @NotNull
    private Date mntnce_expt_ymd;
    private String mntnce_se;
    @NotNull
    private String vendor;
    private String cust_name;
    private String cust_phone;
    private String cust_email;
    @NotNull
    private String solution_name;
    private String snsdr;
    private int cnt;
    private String url;

}

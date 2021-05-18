package com.raonse2.pms_project.model;

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
@Table(name = "ENGINEER_INFO")
public class Engineer_Info {

    @Id
    @GeneratedValue
    private int empno;
    private String emp_name;
    private String mail_address;
    private int create_emp_no;
    private Date create_date;
    private int update_emp_no;
    private Date update_date;

}

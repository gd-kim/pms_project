package com.raonse2.pms_project.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Data                   //lombok
@NoArgsConstructor      //lombok
@AllArgsConstructor     //lombok

@Entity
@Table(name = "EMP")
public class Emp {

    @Id @GeneratedValue
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private Date hiredate;
    private int sal;
    private int comm;
    private int deptno;


}


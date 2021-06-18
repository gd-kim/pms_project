package com.raonse2.pms_project.model;

import org.hibernate.annotations.Immutable;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Immutable
@Getter                   //lombok
@NoArgsConstructor      //lombok
@Table(name="PROJECT_VIEW")
public class Project_viewTable {

    @Id
    private String project_code;
    private String project_name;
    private String customer_name;
    private int customer_no;
    private String sales_name;
    private int salesno;
    private Date start_date;
    private Date end_date;
    private String emp_name;
    private int empno;

}

package com.raonse2.pms_project.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter                   //lombok
@NoArgsConstructor      //lombok
@Entity
@Table(name = "PROJECT_INFO")
public class Project_Info{

    @Id
    private String project_code;
    private String project_name;
    private int customer_no;
    private int build_engineer_no;
    private int sub_engineer_no;
    private int create_emp_no;
    private int update_emp_no;
    private int sales_no;


    @Builder // 롬복, 빌더 패턴 클래스 생성

    public Project_Info(String project_code,
                        String project_name,
                        int customer_no,
                        int build_engineer_no,
                        int sub_engineer_no,
                        int create_emp_no,
                        int update_emp_no,
                        int sales_no) {
        this.project_code = project_code;
        this.project_name = project_name;
        this.customer_no = customer_no;
        this.build_engineer_no = build_engineer_no;
        this.sub_engineer_no = sub_engineer_no;
        this.create_emp_no = create_emp_no;
        this.update_emp_no = update_emp_no;
        this.sales_no = sales_no;
    }
}

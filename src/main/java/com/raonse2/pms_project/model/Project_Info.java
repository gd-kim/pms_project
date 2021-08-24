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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PROJECT_INFO")
    @SequenceGenerator(name = "SEQ_PROJECT_INFO", sequenceName = "SEQ_PROJECT_INFO", allocationSize = 1)
    private int project_no;
    private String project_code;
    private String project_name;
    private String start_date;
    private String end_date;
    private int customer_no;
    private int build_engineer_no;
    private int sub_engineer_no;
    private int salesno;


    @Builder // 롬복, 빌더 패턴 클래스 생성
    public Project_Info(String project_code, String project_name,String start_date, String end_date, int customer_no, int build_engineer_no, int sub_engineer_no, int salesno) {
        this.project_code = project_code;
        this.project_name = project_name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.customer_no = customer_no;
        this.build_engineer_no = build_engineer_no;
        this.sub_engineer_no = sub_engineer_no;
        this.salesno = salesno;
    }
}

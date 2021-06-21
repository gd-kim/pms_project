package com.raonse2.pms_project.dto.project_view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.raonse2.pms_project.model.Engineer_Info;
import com.raonse2.pms_project.model.Project_viewTable;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 고유 Entity는 건들면 안됨.
 * 따로 DTO 객체 만들어서 전달.
 */
@Getter
public class Project_viewResponseDto {

    private String project_code;
    private String project_name;
    private String customer_name;
    private int customer_no;
    private String sales_name;
    private int salesno;
    private String start_date;
    private String end_date;
    private String emp_name;
    private int empno;

    public Project_viewResponseDto(Project_viewTable entity){
        this.project_code = entity.getProject_code();
        this.project_name = entity.getProject_name();
        this.customer_name = entity.getCustomer_name();
        this.customer_no = entity.getCustomer_no();
        this.sales_name = entity.getSales_name();
        this.salesno = entity.getSalesno();
        this.start_date = entity.getStart_date();
        this.end_date = entity.getEnd_date();
        this.emp_name = entity.getEmp_name();
        this.empno = entity.getEmpno();
    }
}

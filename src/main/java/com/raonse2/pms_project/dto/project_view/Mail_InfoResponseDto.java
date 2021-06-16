package com.raonse2.pms_project.dto.project_view;

import com.raonse2.pms_project.model.Mail_Info;
import lombok.Getter;

@Getter
public class Mail_InfoResponseDto {
    private String mail_no;
    private String emp_name;
    private String mail_title;
    private String solution_name;
    private String send_date;

    public Mail_InfoResponseDto(Mail_Info entity){
        this.mail_no = entity.getMail_no();
        this.emp_name = entity.getEmp_name();
        this.mail_title = entity.getMail_title();
        this.solution_name = entity.getMail_product_name();
        this.send_date = entity.getSend_date();
    }
}

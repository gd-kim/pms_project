package com.raonse2.pms_project.dto.mail_info;

import com.raonse2.pms_project.model.Mail_Info;
import lombok.Getter;

@Getter
public class Mail_InfoResponseDto {
    private Integer mail_no;
    private String emp_name;
    private String title;
    private String message;
    private String mail_product_name;
    private String send_date;
    private String address;

    public Mail_InfoResponseDto(Mail_Info entity){
        this.mail_no = entity.getMail_no();
        this.emp_name = entity.getEmp_name();
        this.title = entity.getTitle();
        this.message = entity.getMessage();
        this.mail_product_name = entity.getMail_product_name();
        this.send_date = entity.getSend_date();
        this.address = entity.getAddress();
    }
}

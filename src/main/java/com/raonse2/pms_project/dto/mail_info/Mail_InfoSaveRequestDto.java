package com.raonse2.pms_project.dto.mail_info;

import com.raonse2.pms_project.model.Mail_Info;
import lombok.Builder;

public class Mail_InfoSaveRequestDto {
    private String emp_name;
    private String mail_title;
    private String content;
    private String mail_product_name;
    private String send_date;
    private String mail_address;

    @Builder
    public Mail_InfoSaveRequestDto(String emp_name, String mail_title, String content, String mail_product_name, String send_date, String mail_address) {
        this.emp_name = emp_name;
        this.mail_title = mail_title;
        this.content = content;
        this.mail_product_name = mail_product_name;
        this.send_date = send_date;
        this.mail_address = mail_address;
    }

    public Mail_Info toEntity() {
        return Mail_Info.builder()
                .emp_name(emp_name)
                .mail_title(mail_title)
                .content(content)
                .mail_product_name(mail_product_name)
                .send_date(send_date)
                .mail_address(mail_address)
                .build();
    }
}

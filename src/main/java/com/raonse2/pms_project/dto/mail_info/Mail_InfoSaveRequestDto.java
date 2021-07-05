package com.raonse2.pms_project.dto.mail_info;

import com.raonse2.pms_project.model.Mail_Info;
import lombok.Builder;

public class Mail_InfoSaveRequestDto {
    private String emp_name;
    private String title;
    private String message;
    private String mail_product_name;
    private String send_date;
    private String address;
    private String customer;

    @Builder
    public Mail_InfoSaveRequestDto(String emp_name, String title, String message, String mail_product_name, String send_date, String address, String customer) {
        this.emp_name = emp_name;
        this.title = title;
        this.message = message;
        this.mail_product_name = mail_product_name;
        this.send_date = send_date;
        this.address = address;
        this.customer = customer;
    }

    public Mail_Info toEntity() {
        return Mail_Info.builder()
                .emp_name(emp_name)
                .title(title)
                .message(message)
                .mail_product_name(mail_product_name)
                .send_date(send_date)
                .address(address)
                .customer(customer)
                .build();
    }
}

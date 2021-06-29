package com.raonse2.pms_project.model;

import lombok.*;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Getter                   //lombok
@NoArgsConstructor      //lombok
@Table(name="MAIL_INFO")
public class Mail_Info {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MAIL_INFO")
    @SequenceGenerator(name = "SEQ_MAIL_INFO", sequenceName = "SEQ_MAIL_INFO", allocationSize = 1)
    private String mail_no;

    private String emp_name;
    private String mail_title;
    private String content;
    private String mail_product_name;
    private String send_date;
    private String mail_address;

    @Builder
    public Mail_Info(String emp_name, String mail_title, String content, String mail_product_name, String send_date, String mail_address) {
        this.emp_name = emp_name;
        this.mail_title = mail_title;
        this.content = content;
        this.mail_product_name = mail_product_name;
        this.send_date = send_date;
        this.mail_address = mail_address;
    }
}

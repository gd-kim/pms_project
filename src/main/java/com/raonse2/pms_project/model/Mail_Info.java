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
    private Integer mail_no;

    private String emp_name;
    private String title;
    private String message;
    private String mail_product_name;
    private String send_date;
    private String address;
    private String customer;

    @Builder
    public Mail_Info(String emp_name, String title, String message, String mail_product_name, String send_date, String address, String customer) {
        this.emp_name = emp_name;
        this.title = title;
        this.message = message;
        this.mail_product_name = mail_product_name;
        this.send_date = send_date;
        this.address = address;
        this.customer = customer;
    }
}

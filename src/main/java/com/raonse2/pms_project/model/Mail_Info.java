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
    private String mail_no;
    private String emp_name;
    private String mail_title;
    private String mail_product_name;
    private String send_date;
}

package com.raonse2.pms_project.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter                   //lombok
@NoArgsConstructor      //lombok
@Entity
@Table(name = "ENGINEER_INFO")
public class Engineer_Info{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ENGINEER_EMPNO")
    @SequenceGenerator(name = "SEQ_ENGINEER_EMPNO", sequenceName = "SEQ_ENGINEER_EMPNO", allocationSize = 1)
    private int empno;
    private String emp_name;
    private String mail_address;

    @Builder // 롬복, 빌더 패턴 클래스 생성
    public Engineer_Info(String emp_name, String mail_address){
        this.emp_name= emp_name;
        this.mail_address= mail_address;

    }
    public void update(String emp_name, String mail_address){
        this.emp_name= emp_name;
        this.mail_address= mail_address;
    }

}

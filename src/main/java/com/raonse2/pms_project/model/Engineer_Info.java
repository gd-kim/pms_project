package com.raonse2.pms_project.model;

import com.raonse2.pms_project.util.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Getter                   //lombok
@NoArgsConstructor      //lombok
@Entity
@Table(name = "ENGINEER_INFO")
public class Engineer_Info extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ENGINEER_EMPNO")
    @SequenceGenerator(name = "ENGINEER_EMPNO_GENERATOR", sequenceName = "SEQ_ENGINEER_EMPNO", allocationSize = 1)
    private int empno;
    private String emp_name;
    private String mail_address;
    private int create_emp_no;
    private int update_emp_no;

    @Builder // 롬복, 빌더 패턴 클래스 생성
    public Engineer_Info(String emp_name, String mail_address, int create_emp_no, int update_emp_no){
        this.emp_name= emp_name;
        this.mail_address= mail_address;
        this.create_emp_no= create_emp_no;
        this.update_emp_no= update_emp_no;

    }
    public void update(String emp_name, String mail_address,int update_emp_no){
        this.emp_name= emp_name;
        this.mail_address= mail_address;
        this.update_emp_no= update_emp_no;
    }

}

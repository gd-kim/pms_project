package com.raonse2.pms_project.dto.engineer_info;

import com.raonse2.pms_project.model.Engineer_Info;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;

/**
 * 고유 Entity는 건들면 안됨.
 * 따로 DTO 객체 만들어서 전달.
 */
@Getter
public class Engineer_InfoSaveRequestDto {

    private String emp_name;
    private String mail_address;

    @Builder
    public Engineer_InfoSaveRequestDto(String emp_name, String mail_address){
        this.emp_name = emp_name;
        this.mail_address = mail_address;
    }

    public Engineer_Info toEntity(){
        return Engineer_Info.builder()
                .emp_name(emp_name)
                .mail_address(mail_address)
                .build();
    }
}

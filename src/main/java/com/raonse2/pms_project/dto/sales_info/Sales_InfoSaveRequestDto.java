package com.raonse2.pms_project.dto.sales_info;

import com.raonse2.pms_project.model.Sales_Info;
import lombok.Builder;
import lombok.Getter;

/**
 * 고유 Entity는 건들면 안됨.
 * 따로 DTO 객체 만들어서 전달.
 */
@Getter
public class Sales_InfoSaveRequestDto {

    private String sales_name;
    private String sales_team;
    private String email_address;
    @Builder
    public Sales_InfoSaveRequestDto(String sales_name, String sales_team, String email_address){
        this.sales_name = sales_name;
        this.sales_team = sales_team;
        this.email_address = email_address;

    }

    public Sales_Info toEntity(){
        return Sales_Info.builder()
                .sales_name(sales_name)
                .sales_team(sales_team)
                .email_address(email_address)
                .build();
    }
}

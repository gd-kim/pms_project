package com.raonse2.pms_project.dto.customer_info;

import com.raonse2.pms_project.model.Customer_Info;
import lombok.Getter;
    /**
     * 고유 Entity는 건들면 안됨.
     * 따로 DTO 객체 만들어서 전달.
     */
    @Getter
    public class Customer_infoResponseDto {
        private int customerno;
        private String customer_name;
        private int engineer_no;

        public Customer_infoResponseDto(Customer_Info entity){
            this.customerno = entity.getCustomerno();
            this.customer_name = entity.getCustomer_name();
            this.engineer_no = entity.getEngineer_no();
        }
    }


package com.raonse2.pms_project;

import com.raonse2.pms_project.model.Engineer_Info;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class Engineer_InfoTestController {

    @Test
    public void Engineer_InfoSaveRequestDto_test() {
        final Engineer_Info engineer_info = Engineer_Info.builder()
                .emp_name("홍길동")
                .mail_address("honggildong@raoncorp.com")
                .create_emp_no(1)
                .update_emp_no(1)
                .build();
        System.out.println("EMPNO ::" + engineer_info.getEmpno());
        assertThat(engineer_info.getEmp_name()).isEqualTo("홍길동");
        assertThat(engineer_info.getMail_address()).isEqualTo("honggildong@raoncorp.com");
    }

}

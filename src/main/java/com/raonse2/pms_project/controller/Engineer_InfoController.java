package com.raonse2.pms_project.controller;

import com.raonse2.pms_project.dto.Engineer_InfoResponseDto;
import com.raonse2.pms_project.service.Engineer_InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1.0/engineer-info")
public class Engineer_InfoController {

    @Autowired
    Engineer_InfoService engineer_infoService;
    /*
     *** REST API URL설계 RULES
     1. 마지막에 / 를 포함하지 않는다.
     2. _ 대신 - 를 사용한다.
     3. 소문자를 사용한다.
     4. 행위는 url에 포함하지 않는다. ex) delete, update 등등..
     */

    @GetMapping("/1/{empno}")
    public Engineer_InfoResponseDto findByEmpno (@PathVariable("empno") int empno){
        return engineer_infoService.findByEmpno(empno);
    }

    @DeleteMapping("/2/{empno}")
    public void delete(@PathVariable("empno") int empno){
        engineer_infoService.delete(empno);
    }


}

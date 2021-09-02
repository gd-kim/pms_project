package com.raonse2.pms_project.controller;

import com.raonse2.pms_project.dto.engineer_info.Engineer_InfoResponseDto;
import com.raonse2.pms_project.dto.engineer_info.Engineer_InfoUpdateRequestDto;
import com.raonse2.pms_project.querydslRepository.Product_InfoRepositorySupport;
import com.raonse2.pms_project.querydslRepository.Project_InfoRepositorySupport;
import com.raonse2.pms_project.service.Engineer_InfoService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1.0/project-info")
public class ProjectApiController {
     /*
     *** REST API URL설계 RULES
     1. 마지막에 / 를 포함하지 않는다.
     2. _ 대신 - 를 사용한다.
     3. 소문자를 사용한다.
     4. 행위는 url에 포함하지 않는다. ex) delete, update 등등..
     */

    @Autowired
    Project_InfoRepositorySupport projectInfoRepositorySupport;

    @Autowired
    Engineer_InfoService engineer_infoService;

    @PutMapping("/4")
    public Engineer_InfoResponseDto updateProjectEngineer(@RequestBody String requestData){
        JSONObject data = new JSONObject(requestData);
        int empno = Integer.parseInt((String)data.get("empno"));
        String projectCode = (String) data.get("projectCode");
        projectInfoRepositorySupport.updateProjectEngineer(empno, projectCode);
        return engineer_infoService.findByEmpno(empno);

    }

}

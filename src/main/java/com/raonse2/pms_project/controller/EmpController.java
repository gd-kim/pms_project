package com.raonse2.pms_project.controller;

import com.raonse2.pms_project.dto.EmpResponseDto;
import com.raonse2.pms_project.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1.0/Emp")
public class EmpController {

    @Autowired
    EmpService empService;


    @GetMapping("/getEmp/{empno}")
    public EmpResponseDto findByEmpno (@PathVariable("empno") int empno){
        return empService.findByEmpno(empno);
    }

    @DeleteMapping("/delete/{empno}")
    public void delete(@PathVariable("empno") int empno){
        empService.delete(empno);
    }


}

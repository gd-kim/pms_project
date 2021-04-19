package com.raonse2.pms_project.dto;

import com.raonse2.pms_project.model.Emp;
import lombok.Getter;

import java.sql.Date;

/**
 * 고유 Entity는 건들면 안됨.
 * 따로 DTO 객체 만들어서 전달.
 */
@Getter
public class EmpResponseDto {

    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private Date hiredate;
    private int sal;
    private int comm;
    private int deptno;

    public EmpResponseDto(Emp entity){
        this.empno = entity.getEmpno();
        this.ename = entity.getEname();
        this.job = entity.getJob();
        this.mgr = entity.getMgr();
        this.hiredate = entity.getHiredate();
        this.sal = entity.getSal();
        this.comm = entity.getComm();
        this.deptno = entity.getDeptno();
    }
}

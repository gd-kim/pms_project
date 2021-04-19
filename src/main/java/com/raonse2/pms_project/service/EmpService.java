package com.raonse2.pms_project.service;

import com.raonse2.pms_project.dto.EmpResponseDto;
import com.raonse2.pms_project.model.Emp;
import com.raonse2.pms_project.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class EmpService {
    private final EmpRepository EmpRepository;


    @Transactional(readOnly = true)
    public EmpResponseDto findByEmpno(int empno) {
    Emp entity = EmpRepository.findByEmpno(empno);

        return new EmpResponseDto(entity);
    }

    @Transactional
    public void delete(int empno){
        Emp emp = EmpRepository.findByEmpno(empno);
        EmpRepository.delete(emp);
    }

}

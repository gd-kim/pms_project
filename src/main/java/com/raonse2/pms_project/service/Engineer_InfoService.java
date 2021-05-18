package com.raonse2.pms_project.service;

import com.raonse2.pms_project.dto.Engineer_InfoResponseDto;
import com.raonse2.pms_project.model.Engineer_Info;
import com.raonse2.pms_project.repository.Engineer_InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class Engineer_InfoService {
    private final Engineer_InfoRepository Engineer_InfoRepository;


    @Transactional(readOnly = true)
    public Engineer_InfoResponseDto findByEmpno(int id) {
        Engineer_Info entity = Engineer_InfoRepository.findByEmpno(id);

        return new Engineer_InfoResponseDto(entity);
    }

    @Transactional
    public void delete(int id){
        Engineer_Info engineer_Info = Engineer_InfoRepository.findByEmpno(id);
        Engineer_InfoRepository.delete(engineer_Info);
    }

}

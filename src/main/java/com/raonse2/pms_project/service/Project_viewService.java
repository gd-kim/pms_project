package com.raonse2.pms_project.service;

import com.raonse2.pms_project.dto.engineer_info.Engineer_InfoResponseDto;
import com.raonse2.pms_project.dto.engineer_info.Engineer_InfoSaveRequestDto;
import com.raonse2.pms_project.dto.engineer_info.Engineer_InfoUpdateRequestDto;
import com.raonse2.pms_project.dto.project_view.Project_viewResponseDto;
import com.raonse2.pms_project.model.Engineer_Info;
import com.raonse2.pms_project.model.Project_viewTable;
import com.raonse2.pms_project.repository.Engineer_InfoRepository;
import com.raonse2.pms_project.repository.Project_viewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class Project_viewService {
    private final Project_viewRepository project_viewRepository;


    @Transactional(readOnly = true)
    public List<Project_viewTable> findByAll() {

        List<Project_viewTable> list = project_viewRepository.findAll();

        return list;
    }

}

package com.raonse2.pms_project.service;

import com.raonse2.pms_project.dto.project_view.Mail_InfoResponseDto;
import com.raonse2.pms_project.repository.Mail_InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class Mail_InfoService {
    private final Mail_InfoRepository mailInfoRepository;

    @Transactional(readOnly = true)
    public List<Mail_InfoResponseDto> findByAll() {
        return mailInfoRepository.findAll().stream().map(Mail_InfoResponseDto::new).collect(Collectors.toList());
    }
}
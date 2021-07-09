package com.raonse2.pms_project.controller;

import com.raonse2.pms_project.ApiResponse.ApiAdapter;
import com.raonse2.pms_project.ApiResponse.MailResponse;
import com.raonse2.pms_project.dto.MailDto;
import com.raonse2.pms_project.dto.MailResponseDto;
import com.raonse2.pms_project.dto.mail_info.Mail_InfoSaveRequestDto;
import com.raonse2.pms_project.service.MailService;
import com.raonse2.pms_project.service.Mail_InfoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MailController {
    private final MailService mailService;
    private final Mail_InfoService mailInfoService;
    @PostMapping("/api/send")
    public @ResponseBody
    MailResponse execMail(@RequestBody MailDto mailDto) {
        MailResponseDto mailResponseDto = null;
        try{
            String sendResult = mailService.mailSend(mailDto);

            mailResponseDto = new MailResponseDto(sendResult);
        } catch(Exception e){
            mailResponseDto = new MailResponseDto("전송 실패. "+ e);
        }
        return ApiAdapter.mailResponse(mailResponseDto);
    }

    @PostMapping("/api/mail-save")
    public void save(@RequestBody Mail_InfoSaveRequestDto requestDto) {
        mailInfoService.save(requestDto);
    }
}

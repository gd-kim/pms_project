package com.raonse2.pms_project.controller;

import com.raonse2.pms_project.dto.project_view.Mail_InfoResponseDto;
//import com.raonse2.pms_project.service.Mail_InfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@AllArgsConstructor
public class ViewController {
/*    @Autowired
    Mail_InfoService mailInfoService;

    @GetMapping("/mail")
    public String toMail(){
        return "mail";
    }
    @GetMapping("/select")
    public String toSelect(){
        return "select";
    }

    @RequestMapping("/lookup")
    public ModelAndView toLookup(ModelAndView mv){
        mv.setViewName("lookup");
        List<Mail_InfoResponseDto> miList = mailInfoService.findByAll();
        mv.getModelMap().addAttribute("miList", miList);

        return mv;
    }*/
}

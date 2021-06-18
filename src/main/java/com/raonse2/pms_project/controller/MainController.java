package com.raonse2.pms_project.controller;

import com.raonse2.pms_project.dto.product_info.Product_InfoResponseDto;
import com.raonse2.pms_project.dto.project_view.Project_viewResponseDto;
import com.raonse2.pms_project.model.Product_Info;
import com.raonse2.pms_project.model.Project_viewTable;
import com.raonse2.pms_project.querydslRepository.Product_InfoRepositorySupport;
import com.raonse2.pms_project.service.Engineer_InfoService;
import com.raonse2.pms_project.service.Project_viewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    Engineer_InfoService engineer_infoService;

    @Autowired
    Project_viewService project_viewService;

    @Autowired
    Product_InfoRepositorySupport productInfoRepositorySupport;


    @RequestMapping("/hello")
    public String hello(Model model) {


        model.addAttribute("name","gdkim");
        return "hello";
    }

    @RequestMapping("/tables")
    public ModelAndView tables(ModelAndView mv){
        mv.setViewName("tables");
        List<Project_viewResponseDto> pjList = project_viewService.findByAll();
        mv.getModelMap().addAttribute("pjList", pjList);
        return mv;
    }

    @RequestMapping("/pjt-detail/{pjtcode}")
    public ModelAndView pjtdetail(ModelAndView mv, @PathVariable("pjtcode") String pjtcode){
        //System.out.println("pjtcode:::: "+ pjtcode);

        List<Product_InfoResponseDto> product_infos = productInfoRepositorySupport.findByProductNo(pjtcode);
        mv.setViewName("detail");
        mv.addObject("pjtcode",pjtcode);
        mv.addObject("product_infos",product_infos);

        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login(ModelAndView mv){
        mv.setViewName("login");
        return mv;
    }



}

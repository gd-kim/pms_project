package com.raonse2.pms_project.controller;

import com.raonse2.pms_project.dto.customer_emp_info.Customer_emp_infoResponseDto;
import com.raonse2.pms_project.dto.engineer_info.Engineer_InfoResponseDto;
import com.raonse2.pms_project.dto.product_info.Product_InfoResponseDto;
import com.raonse2.pms_project.dto.project_view.Project_viewResponseDto;
import com.raonse2.pms_project.querydslRepository.Product_InfoRepositorySupport;
import com.raonse2.pms_project.service.Customer_Emp_InfoService;
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

    @Autowired
    Customer_Emp_InfoService customer_emp_infoService;

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

    @RequestMapping("/selectEngineer")
    public ModelAndView selectEngineer(ModelAndView mv){
        mv.setViewName("selectEngineer");
        List<Engineer_InfoResponseDto> engineerList = engineer_infoService.findAll();
        mv.getModelMap().addAttribute("engineerList", engineerList);
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

    @RequestMapping("/customerEmp")
    public ModelAndView customerEmp(ModelAndView mv){
        mv.setViewName("customerEmp");
        List<Customer_emp_infoResponseDto> customerEmpList = customer_emp_infoService.findByAll();
        mv.getModelMap().addAttribute("customerEmpList", customerEmpList);
        return mv;
    }
}

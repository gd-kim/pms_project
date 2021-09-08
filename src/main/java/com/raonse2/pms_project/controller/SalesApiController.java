package com.raonse2.pms_project.controller;

import com.raonse2.pms_project.dto.engineer_info.Engineer_InfoResponseDto;
import com.raonse2.pms_project.dto.engineer_info.Engineer_InfoSaveRequestDto;
import com.raonse2.pms_project.dto.engineer_info.Engineer_InfoUpdateRequestDto;
import com.raonse2.pms_project.dto.sales_info.Sales_InfoResponseDto;
import com.raonse2.pms_project.dto.sales_info.Sales_InfoSaveRequestDto;
import com.raonse2.pms_project.dto.sales_info.Sales_InfoUpdateRequestDto;
import com.raonse2.pms_project.service.Engineer_InfoService;
import com.raonse2.pms_project.service.Sales_InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1.0/sales-info")
public class SalesApiController {
    private final Sales_InfoService sales_infoService;

     /*** REST API URL설계 RULES
     1. 마지막에 / 를 포함하지 않는다.
     2. _ 대신 - 를 사용한다.
     4. 행위는 url에 포함하지 않는다. ex) delete, update 등등..
     */


    @GetMapping("/1/salesno")
    public Sales_InfoResponseDto findBySalesno (@RequestParam (required=true,defaultValue="1") int salesno){
        return sales_infoService.findBySalesno(salesno);
    }


    @DeleteMapping("/2/{salesno}")
    public void delete(@PathVariable("salesno") int salesno){
        sales_infoService.delete(salesno);
    }


    @PostMapping("/3/sales-info")
    public void save(@RequestBody Sales_InfoSaveRequestDto requestDto){
        sales_infoService.save(requestDto);
    }


    @PutMapping("/4/{salesno}")
    public void update(@PathVariable int salesno, @RequestBody Sales_InfoUpdateRequestDto requestDto){
        sales_infoService.update(salesno, requestDto);
    }


}

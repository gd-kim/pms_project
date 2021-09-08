package com.raonse2.pms_project.service;

import com.raonse2.pms_project.dto.sales_info.Sales_InfoResponseDto;
import com.raonse2.pms_project.dto.sales_info.Sales_InfoSaveRequestDto;
import com.raonse2.pms_project.dto.sales_info.Sales_InfoUpdateRequestDto;
import com.raonse2.pms_project.model.Sales_Info;
import com.raonse2.pms_project.repository.Sales_InfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class Sales_InfoService {
    private final Sales_InfoRepository sales_InfoRepository;

    @Transactional(readOnly = true)
    public List<Sales_InfoResponseDto> findAll() {
        return sales_InfoRepository.findAll().stream().map(Sales_InfoResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Sales_InfoResponseDto findBySalesno(int salesno) {
        Sales_Info entity = sales_InfoRepository.findBySalesno(salesno).orElseThrow(()-> new IllegalArgumentException("해당 영업은 존재하지 않습니다.. salesno= "+salesno));

        return new Sales_InfoResponseDto(entity);
    }

    @Transactional
    public void delete(int salesno){
        Sales_Info entity = sales_InfoRepository.findBySalesno(salesno).orElseThrow(()-> new IllegalArgumentException("해당 영업은 존재하지 않습니다.. salesno= "+salesno));
        sales_InfoRepository.delete(entity);
    }

    @Transactional
    public void save(Sales_InfoSaveRequestDto requestDto){
        sales_InfoRepository.save(requestDto.toEntity());
    }

    @Transactional
    public void update(int salesno, Sales_InfoUpdateRequestDto requestDto){
        Sales_Info sales_info = sales_InfoRepository.findBySalesno(salesno).orElseThrow(()-> new IllegalArgumentException("해당 영업은 존재하지 않습니다.. salesno= "+salesno));
        sales_info.update(requestDto.getSales_name(), requestDto.getSales_team(), requestDto.getEmail_address());
    }

}

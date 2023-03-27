package com.multicampus.springboot.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class PageResponseDTO <E>{
    private int page;
    private int size;   // 그룹의 크기
    private int total;

    //그룹의 시작페이지 번호
    private int start;
    //그룹의 끝 페이지 번호
    private int end;

    //이전 페이지의 존재 여부
    private boolean prev;
    //다음 페이지의 존재 여부
    private boolean next;

    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO,List<E>dtoList,int total){
        this.page=pageRequestDTO.getPage();
        this.size=pageRequestDTO.getSize();

        this.total=total;
        this.dtoList=dtoList;

        this.end = (int)(Math.ceil(this.page/10.0))*10; //ceil : 올림

        this.start =this.end-9;

        int last =(int)(Math.ceil((total/(double)size)));

        this.end =end>last ? last:end;

        this.prev =this.start>1;

        this.next = total> this.end * this.size;
    }

}

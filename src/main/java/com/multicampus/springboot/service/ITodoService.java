package com.multicampus.springboot.service;

import com.multicampus.springboot.dto.PageRequestDTO;
import com.multicampus.springboot.dto.PageResponseDTO;
import com.multicampus.springboot.dto.TodoDTO;

import java.util.List;

public interface ITodoService {

    List<TodoDTO> selectAll();
    int insert(TodoDTO todoDTO);
    TodoDTO view(String tno);
    int modify(TodoDTO todoDTO);
    int remove(String tno);
    PageResponseDTO<TodoDTO>search(PageRequestDTO pageRequestDTO);
    //List<TodoDTO> getAll();
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
}

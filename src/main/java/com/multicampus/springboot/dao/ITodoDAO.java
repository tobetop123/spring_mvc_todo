package com.multicampus.springboot.dao;

import com.multicampus.springboot.dto.PageRequestDTO;
import com.multicampus.springboot.dto.PageResponseDTO;
import com.multicampus.springboot.dto.TodoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ITodoDAO {
    //String getTime();

    List<TodoDTO> selectAllDAO();
    List<TodoDTO> selectList(PageRequestDTO pageRequestDTO);
    int getCount(PageRequestDTO pageRequestDTO);
    int insertDAO(TodoDTO todoDTO);
    TodoDTO viewDAO(String tno);
    int modifyDAO(TodoDTO todoDTO);
    int removeDAO(String tno);
    List<TodoDTO> searchDAO(PageRequestDTO dto);

}

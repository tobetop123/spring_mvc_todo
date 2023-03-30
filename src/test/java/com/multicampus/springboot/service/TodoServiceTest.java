package com.multicampus.springboot.service;

import static org.assertj.core.api.Assertions.*;
import com.multicampus.springboot.dao.ITodoDAO;
import com.multicampus.springboot.dto.TodoDTO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Nested
class TodoServiceTest {

    @Autowired
    TodoService service;

    @Nested
    class Test1 {

        @DisplayName("모든 글을 리스트로 출력")
        @Test
            //@RepeatedTest(value = 100, name="{displayName}")
        void selectAll() {
            List<TodoDTO> list = service.selectAll();
            Assertions.assertNotNull(list);
        }

        @DisplayName("상세보기")
        //@Test
        //@Disabled("문제가 해결될 떄까지 테스트 중단")
        @ParameterizedTest      //반복
        @CsvSource(value = {"1", "10", "23"})
        void view(String tno) {
            //String tno = "10";
            TodoDTO todoDTO = service.view(tno);
            Assertions.assertNotNull(todoDTO);
            //assertThat(todoDTO.getTitle()).isEqualTo("");
        }
    }
    @DisplayName("글 추가")
    @Test
    void insert() {
    }

    @DisplayName("글 변경")
    @Test
    void modify() {
    }

    @DisplayName("글 삭제")
    @Test
    void remove() {
    }

    @Test
    void search() {
    }

    @Test
    void getList() {
    }
}
package com.multicampus.springboot.controller;

import com.multicampus.springboot.dto.PageRequestDTO;
import com.multicampus.springboot.dto.TodoDTO;
import com.multicampus.springboot.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MyController {

    @Autowired
    private ITodoService service;

    @GetMapping("/")
    public @ResponseBody String root(){
        return "todo 게시판 만들기";
    }

    /*@GetMapping("/list")
    public String list(Model model){
        model.addAttribute("list", service.selectAll());
        return "list";
    }*/

    @GetMapping("/register")
    public String register(){

        return "register";
    }

    @PostMapping("/registerProcess")
    public String registerProcess(TodoDTO dto){
        service.insert(dto);
        return "redirect:list";
    }

    @GetMapping("/view")
    public String view(HttpServletRequest request, PageRequestDTO pageRequestDTO,Model model){
        String tno= request.getParameter("tno");
        model.addAttribute("dto",service.view(tno));
        return "view";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String modify(HttpServletRequest request, PageRequestDTO pageRequestDTO,Model model){
        String tno= request.getParameter("tno");
        model.addAttribute("dto",service.view(tno));
        return "modify";
    }

    @RequestMapping(value = "/modifyProcess",method =RequestMethod.POST)
    public String modifyProcess(TodoDTO dto,Model model){
        if(dto.getFinished() ==null){
            dto.setFinished("0");
        }else{
            dto.setFinished("1");
        }
        service.modify(dto);
        return "redirect:list";
    }

    @GetMapping("/remove")
    public String remove(HttpServletRequest request){
        String tno = request.getParameter("tno");
        service.remove(tno);
        return "redirect:list";
    }

    /*@RequestMapping(value = "/search",method = RequestMethod.GET)
    public String search(PageRequestDTO pageRequestDTO, Model model){
        model.addAttribute("responseDTO",service.search(pageRequestDTO));
        return "list";
    }*/

    @GetMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model){
        /*if(bindingResult.hasErrors()){
            pageRequestDTO = PageRequestDTO.builder().build();
        }*/
        model.addAttribute("responseDTO",service.search(pageRequestDTO));
        model.addAttribute("responseDTO", service.getList(pageRequestDTO));

    }
}

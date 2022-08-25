package com.example.todolist.controller;

import com.example.todolist.dto.ToDoListRequst;
import com.example.todolist.dto.ToDoListResponse;
import com.example.todolist.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ApiController {

    private final ToDoListService toDoListService;


    @GetMapping("/")
    public String get(){
        return "forward:/todolist";
    }

    @PostMapping("/todolist")
    public String todolist(ToDoListRequst toDoListRequst){
        toDoListRequst.setDate(LocalDateTime.now());
        toDoListService.save(toDoListRequst);
        return "redirect:/todolist";
    }
    @GetMapping("/todolist")
    public String getToDoListData(Model model,ToDoListResponse toDoListResponse){
        model.addAttribute("list",toDoListService.findAll());
                return "ToDoList";
    }

    @PostMapping("/del")
    public String Delete(Long number){
        toDoListService.deleteById(number);
        return "redirect:/todolist";
    }



}

package com.example.todolist.service;

import com.example.todolist.dto.ToDoListRequst;
import com.example.todolist.dto.ToDoListResponse;
import com.example.todolist.entity.ToDoList;
import com.example.todolist.repository.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;

    public ToDoList save(ToDoListRequst toDoListRequst){
        return toDoListRepository.save(toDoListRequst.toEntity());
    }

//    public ToDoListResponse findById(Long id){
//        return ;
//    }
    public List<ToDoListResponse> findAll(){
        return toDoListRepository.findAll().stream().map(ToDoListResponse::from).collect(Collectors.toList());
    }

    public void deleteById(Long number){toDoListRepository.deleteById(number);}


}

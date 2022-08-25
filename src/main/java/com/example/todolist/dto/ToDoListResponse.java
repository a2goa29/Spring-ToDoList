package com.example.todolist.dto;

import com.example.todolist.entity.ToDoList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class ToDoListResponse {

    private Long id;

    private String content;

    private LocalDateTime date;

    public static ToDoListResponse from(ToDoList entity){
        return  new ToDoListResponse(entity.getId(),entity.getContent(),entity.getDate());
    }


}

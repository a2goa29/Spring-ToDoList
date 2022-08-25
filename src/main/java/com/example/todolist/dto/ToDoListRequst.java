package com.example.todolist.dto;

import com.example.todolist.entity.ToDoList;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ToDoListRequst {

    private Long id;
    private String content;

    private LocalDateTime date;

    public ToDoList toEntity(){
        return ToDoList.builder()
                .content(content)
                .date(date)
                .build();
    }
}

package com.toyproject.todolist.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RespGetTodoListDto {
    private int todoId;
    private String content;
    private int status;
    private String date;
}

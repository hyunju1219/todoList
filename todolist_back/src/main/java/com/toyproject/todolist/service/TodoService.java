package com.toyproject.todolist.service;

import com.toyproject.todolist.dto.ReqAddTodoDto;
import com.toyproject.todolist.dto.ReqUpdateTodoDto;
import com.toyproject.todolist.dto.RespGetTodoListDto;

import java.util.List;

public interface TodoService {
    int addTodo(ReqAddTodoDto reqAddTodoDto);
    int updateTodo(ReqUpdateTodoDto reqUpdateTodoDto);
    int deleteTodo(int todoId);
    List<RespGetTodoListDto> getTodoList(String date);
    int updateTodoStatus(int todoId);
}

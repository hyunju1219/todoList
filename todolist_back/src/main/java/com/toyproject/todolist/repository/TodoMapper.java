package com.toyproject.todolist.repository;

import com.toyproject.todolist.entity.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    int save(Todo todo);
    int update(Todo todo);
    int delete(int todoId);
    List<Todo> findTodoListByDate(String date);
    int updateStatus(int todoId);
}

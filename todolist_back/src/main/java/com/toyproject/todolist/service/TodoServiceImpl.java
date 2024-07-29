package com.toyproject.todolist.service;

import com.toyproject.todolist.dto.ReqAddTodoDto;
import com.toyproject.todolist.dto.ReqUpdateTodoDto;
import com.toyproject.todolist.dto.RespGetTodoListDto;
import com.toyproject.todolist.entity.Todo;
import com.toyproject.todolist.repository.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.spi.ToolProvider;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoMapper todoMapper;

    @Override
    public int addTodo(ReqAddTodoDto reqAddTodoDto) {
        Todo todo = Todo.builder()
                .content(reqAddTodoDto.getContent())
                .status(reqAddTodoDto.getStatus())
                .date(reqAddTodoDto.getDate())
                .build();
        return todoMapper.save(todo);
    }

    @Override
    public int updateTodo(ReqUpdateTodoDto reqUpdateTodoDto) {
        Todo todo = Todo.builder()
                .todoId(reqUpdateTodoDto.getTodoId())
                .content(reqUpdateTodoDto.getContent())
                .build();
        return todoMapper.update(todo);
    }

    @Override
    public int deleteTodo(int todoId) {
        return todoMapper.delete(todoId);
    }

    @Override
    public List<RespGetTodoListDto> getTodoList(String date) {
        List<RespGetTodoListDto> dtos = new ArrayList<>();
        List<Todo> todos = todoMapper.findTodoListByDate(date);
        for (Todo todo : todos) {
            RespGetTodoListDto dto = RespGetTodoListDto.builder()
                    .todoId(todo.getTodoId())
                    .content(todo.getContent())
                    .status(todo.getStatus())
                    .date(todo.getDate())
                    .build();
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public int updateTodoStatus(int todoId) {
        return todoMapper.updateStatus(todoId);
    }
}

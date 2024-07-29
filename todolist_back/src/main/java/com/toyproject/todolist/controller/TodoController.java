package com.toyproject.todolist.controller;

import com.toyproject.todolist.dto.ReqAddTodoDto;
import com.toyproject.todolist.dto.ReqUpdateTodoDto;
import com.toyproject.todolist.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping("/todo")
    public ResponseEntity<?> addTodo(ReqAddTodoDto reqAddTodoDto) {
        return ResponseEntity.ok().body(todoService.addTodo(reqAddTodoDto));
    }

    @PutMapping("/todo")
    public ResponseEntity<?> updateTodo(ReqUpdateTodoDto reqUpdateTodoDto) {
        return ResponseEntity.ok().body(todoService.updateTodo(reqUpdateTodoDto));
    }

    @DeleteMapping("/todo/{todoId}")
    public ResponseEntity<?> deleteTodo(@PathVariable int todoId) {
        return ResponseEntity.ok().body(todoService.deleteTodo(todoId));
    }

    @GetMapping("/todolist/{date}")
    public ResponseEntity<?> getListApi(@PathVariable String date) {
        return ResponseEntity.ok().body(todoService.getTodoList(date));
    }

    @PutMapping("/todo/{todoId}/status")
    public ResponseEntity<?> updateTodoStatus(@PathVariable int todoId) {
        return ResponseEntity.ok().body(todoService.updateTodoStatus(todoId));
    }


}

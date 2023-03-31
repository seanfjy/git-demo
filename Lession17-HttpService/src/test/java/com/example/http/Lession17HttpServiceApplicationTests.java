package com.example.http;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.example.http.model.Todo;
import com.example.http.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class Lession17HttpServiceApplicationTests {

    //注入代理对象
    @Autowired
    private TodoService todoService;

    //测试访问todos/1
    @Test
    void testQuery() {
        Todo todo = todoService.getTodoById(2);
        log.info("todoService:{}",todoService.getClass());
        log.info(todo.toString());
    }

    @Test
    void createTodo() {
        Todo todo = new Todo();
        todo.setId(1001);
        todo.setUserId(501);
        todo.setCompleted(true);
        todo.setTitle("事项1");

        Todo resultTodo = todoService.createTodo(todo);
        log.info("resultTodo:{}",resultTodo);
    }

    @Test
    void testModify() {
        Todo todo = new Todo();
        todo.setUserId(5001);
        todo.setCompleted(true);
        todo.setTitle("事项2");

        ResponseEntity<Todo> entity = todoService.modifyTodo(3, todo);

        log.info("entity:{}",entity);

    }

    @Test
    void remove() {
        todoService.removeTodo(10);
    }
}

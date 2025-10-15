package com.example.midproj.controller;


import com.example.midproj.model.Task;
import com.example.midproj.model.dto.TaskDTO;
import com.example.midproj.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/task")
    public ResponseEntity<List<Task>> retrieveAllTasks(){
        List<Task> tasks = taskService.get_all();

        return ResponseEntity.ok().body(
                tasks
        );
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<Task> retrieveTask(@PathVariable Long id){
        Task task = taskService.get_task_by_id(id);
        return ResponseEntity.ok().body(
                task
        );
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO){

    }

}

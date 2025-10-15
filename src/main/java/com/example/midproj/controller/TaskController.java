package com.example.midproj.controller;


import com.example.midproj.model.Task;
import com.example.midproj.model.dto.ResponseDto;
import com.example.midproj.model.dto.TaskDTO;
import com.example.midproj.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO taskDTO){
        Task task = taskService.create_task(taskDTO);
        return ResponseEntity.ok().body(
                task
        );
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<ResponseDto> deleteTask(@PathVariable Long id){
        if(taskService.delete_task(id)){
            ResponseDto responseDto = new ResponseDto();
            responseDto.setStatus(200);
            responseDto.setMessage("ok");
            return ResponseEntity.ok().body(responseDto);
        }else{
            ResponseDto responseDto = new ResponseDto();
            responseDto.setStatus(401);
            responseDto.setMessage("Error");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
        }
    }

    @PutMapping("task/{id}")
    public ResponseEntity<ResponseDto> deleteTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
        if(taskService.update_task(id, taskDTO)){
            ResponseDto responseDto = new ResponseDto();
            responseDto.setStatus(200);
            responseDto.setMessage("ok");
            return ResponseEntity.ok().body(responseDto);
        }else{
            ResponseDto responseDto = new ResponseDto();
            responseDto.setStatus(401);
            responseDto.setMessage("Error");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDto);
        }
    }

}

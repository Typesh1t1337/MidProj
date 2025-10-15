package com.example.midproj.service;


import com.example.midproj.model.Task;
import com.example.midproj.model.dto.TaskDTO;
import com.example.midproj.repo.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public Task create_task(TaskDTO taskDTO) {
        Task task = new Task(
                task
        );
    }

    public List<Task> get_all(){
        return taskRepository.findAll();
    }

    public Task get_task_by_id(Long task_id){
        return taskRepository.getReferenceById(task_id);
    }

    public boolean update_task(Long task_id, TaskDTO){
        Task task = taskRepository.getReferenceById(task_id);


    }

    @Transactional
    public boolean delete_task(Long task_id){
        try {
            Task task = taskRepository.getReferenceById(task_id);
            taskRepository.delete(task);
            return true;
        } catch (RuntimeException e){
            return false;
        }
    }

}

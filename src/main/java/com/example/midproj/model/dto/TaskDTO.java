package com.example.midproj.model.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Setter
@Getter
public class TaskDTO {
    public Long id;
    public String name;
    public String description;
    public LocalDateTime deadline;
    public LocalDateTime created_at;
}

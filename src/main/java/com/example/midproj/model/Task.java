package com.example.midproj.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import java.time.LocalDateTime;


@Entity
@Table(name = "task")
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 40, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime created_at;
    private LocalDateTime deadline;

    @PrePersist
    public void prePersist(){
        created_at = LocalDateTime.now();
    }


}

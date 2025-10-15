package com.example.midproj.model.dto;


import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class ResponseDto {
    public int status;
    public String message;
}

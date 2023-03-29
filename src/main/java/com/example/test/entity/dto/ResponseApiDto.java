package com.example.test.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ResponseApiDto {
    Boolean isSuccess;
    String message;
    Object data;
}

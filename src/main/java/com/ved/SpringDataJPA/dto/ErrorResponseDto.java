package com.ved.SpringDataJPA.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ErrorResponseDto {
    private String errorCode;
    private String message;
}

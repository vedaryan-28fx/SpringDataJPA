package com.ved.SpringDataJPA.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private long Id;
    private String name;
    private String email;
}

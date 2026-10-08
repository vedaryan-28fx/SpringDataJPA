package com.ved.SpringDataJPA.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateUserDto {

    @NotBlank
    @NotNull
    @Size(max = 30)
    private String name;

    @NotBlank
    @NotNull
    @Email
    @Size(max = 50)
    private String email;
}

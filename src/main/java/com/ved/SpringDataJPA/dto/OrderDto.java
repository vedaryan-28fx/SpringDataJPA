package com.ved.SpringDataJPA.dto;

import com.ved.SpringDataJPA.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderDto {

    private Long id;
    private String product_name;
    private User user;
}

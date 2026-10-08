package com.ved.SpringDataJPA.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateOrderDto {
    private String product_name;
}

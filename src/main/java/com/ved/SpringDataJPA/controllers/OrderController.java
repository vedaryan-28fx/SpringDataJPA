package com.ved.SpringDataJPA.controllers;

import com.ved.SpringDataJPA.dto.CreateOrderDto;
import com.ved.SpringDataJPA.dto.OrderDto;
import com.ved.SpringDataJPA.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users/{userid}/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@PathVariable long userid, @RequestBody CreateOrderDto createOrderDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(userid,createOrderDto));
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrderByUserId(@PathVariable long userid) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderByUserId(userid));
    }
}

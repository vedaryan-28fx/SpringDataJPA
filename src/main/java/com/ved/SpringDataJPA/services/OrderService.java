package com.ved.SpringDataJPA.services;

import com.ved.SpringDataJPA.dto.CreateOrderDto;
import com.ved.SpringDataJPA.dto.OrderDto;
import com.ved.SpringDataJPA.entity.Order;
import com.ved.SpringDataJPA.entity.User;
import com.ved.SpringDataJPA.exceptions.UserNotFoundException;
import com.ved.SpringDataJPA.repositories.OrderRepository;
import com.ved.SpringDataJPA.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;
    private UserRepository userRepository;

    @Transactional
    public OrderDto createOrder(long userid, CreateOrderDto createOrderDto) {
        User user = userRepository.findById(userid)
                .orElseThrow(() -> new UserNotFoundException("User with id " + userid + " not found"));

        // If it throws exception , the rest block will not work because of @Transactional
        Order order = new Order();
        order.setUser(user);
        order.setProduct_name(createOrderDto.getProduct_name());

        Order savedOrder = orderRepository.save(order);

        return new OrderDto(savedOrder.getId(), savedOrder.getProduct_name(), savedOrder.getUser());
    }

    public List<OrderDto> getOrderByUserId(long userid) {
        List<Order> orders = orderRepository.findByUserId(userid);
        List<OrderDto> orderDtoList = new ArrayList<>();

        orders.forEach(order -> {
            orderDtoList.add(new OrderDto(order.getId(), order.getProduct_name(), order.getUser()));
        });
        return orderDtoList;
    }
}

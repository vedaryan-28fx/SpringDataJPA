package com.ved.SpringDataJPA.repositories;

import com.ved.SpringDataJPA.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findByUserId(long userId);
}

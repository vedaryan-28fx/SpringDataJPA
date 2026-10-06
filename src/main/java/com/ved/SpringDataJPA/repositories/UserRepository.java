package com.ved.SpringDataJPA.repositories;

import com.ved.SpringDataJPA.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

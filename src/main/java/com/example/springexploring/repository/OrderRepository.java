package com.example.springexploring.repository;

import com.example.springexploring.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Collection<? extends Order> findAllByUserWhoOrd_Id(Long id);
}

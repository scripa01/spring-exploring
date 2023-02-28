package com.example.springexploring.repository;

import com.example.springexploring.entity.Order;
import com.example.springexploring.projection.CountOrdersByUserProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Collection<? extends Order> findAllByUserWhoOrd_Id(Long id);

    @Query(nativeQuery = true, value = " SELECT user_id as userId, " +
            " first_name || ' ' || last_name                 AS fullName, " +
            " COUNT(o.id), " +
            " array_to_string(array_agg(distinct o.id), ',') AS orderId " +
            " FROM orders o " +
            " JOIN users u on o.user_id = u.id " +
            " WHERE status = :status " +
            " GROUP BY user_id, first_name, last_name ")
    List<CountOrdersByUserProjections> countOrdersByStatusAndUserWhoOrd(@Param("status") String  status);

}

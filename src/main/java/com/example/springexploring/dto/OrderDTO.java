package com.example.springexploring.dto;
import com.example.springexploring.entity.Item;
import com.example.springexploring.entity.Order;
import com.example.springexploring.entity.Status;
import com.example.springexploring.entity.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderDTO { //Возвращаем ДТО сущности!!!

    private Long id;

    private LocalDateTime creationDate;

    private List<ItemDTO> items = new ArrayList<>();

    private UserDTO userWhoOrd;

    private Long TotalPrice;

    private Status status ;

    private LocalDateTime deliveryDate;


}

package com.example.springexploring.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ItemDTO {

    private String name;
    private String description;
    private int price;
    private LocalDateTime creationDate;
}

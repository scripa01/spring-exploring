package com.example.springexploring.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
    @Id
    @SequenceGenerator(name = "item_sequence", sequenceName = "item_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_sequence")
    private Long id;

    @Column
    @NotEmpty(message = "Name of item should not be empty")
    @Size(min = 2, max = 30, message = "Name 2-30 characters")
    private String name;

    @Column
    @NotEmpty(message = "Description should not be empty")
    @Size(min = 2, max = 300, message = "Name 2-300 characters")
    private String description;

    @Column
    @NotNull(message = "Price should be greater than 0!")
    @Min(value = 0, message = "price should be greater than 0!")
    private int price;

    @ManyToMany(mappedBy = "items")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "item",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Review> reviews = new ArrayList<>();

    @Column(name = "creation_date")
    @Setter(value = AccessLevel.PRIVATE)
    private LocalDateTime creationDate;


    public Item(String name, String description, int price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.creationDate = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}

package com.example.springexploring.entity;

import lombok.*;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    private Long id;

    @Column(name = "creation_date")
    @Setter(value = AccessLevel.PRIVATE)
    private LocalDateTime creationDate = LocalDateTime.now();

    @Column
    @Min(value = 0)
    @Setter(value = AccessLevel.PRIVATE)
    private Long totalPrice = 0L;

    @Column
    @Enumerated(EnumType.STRING)
    private Status status = Status.CREATED;

    @Column
    @Setter(value = AccessLevel.PRIVATE)
    private LocalDateTime deliveryDate;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "order_item",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "Id")
    private User userWhoOrd;


    public Long getTotalPrice() {
        Long sum = 0L;
        for (Item item : items) {
            sum += item.getPrice();
        }
        return sum;
    }

    @PreUpdate
    public void recalculateTotalPrice() {
        this.totalPrice = getTotalPrice();
    }

    public Order(User user, List<Item> items) {
        this.userWhoOrd = user;
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User))
            return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public void deliver() {
        this.status = Status.DELIVERED;
        this.deliveryDate = LocalDateTime.now();
    }
    public Long getDifferenceDaysDelivery(){
        Duration duration = Duration.between(this.creationDate, this.deliveryDate);
        return duration.toDays();
    }
}

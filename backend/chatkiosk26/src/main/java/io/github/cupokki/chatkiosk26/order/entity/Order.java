package io.github.cupokki.chatkiosk26.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.Builder;

import java.util.List;

@Entity
@Builder
public record Order(
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        @OneToMany(mappedBy = "order_item_id")
        List<OrderItem> orderItems

){ }

package io.github.cupokki.chatkiosk26.stock.entity;

import io.github.cupokki.chatkiosk26.order.entity.Product;
import jakarta.persistence.*;

@Entity
public record Stock(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        Long quantity,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "item_id")
        Product item
) {
}

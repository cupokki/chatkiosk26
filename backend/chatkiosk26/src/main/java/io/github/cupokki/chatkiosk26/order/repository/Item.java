package io.github.cupokki.chatkiosk26.order.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public record Item (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        String name,

        BigDecimal price

) {
}

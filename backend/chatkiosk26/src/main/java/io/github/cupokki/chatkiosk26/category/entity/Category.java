package io.github.cupokki.chatkiosk26.category.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public record Category (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        String name
) { }

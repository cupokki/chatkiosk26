package io.github.cupokki.chatkiosk26.store.repository;

import jakarta.persistence.*;

import java.util.List;

@Entity
public record Store(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        String title,

        List<Stock> menu

        List<>


) {
}

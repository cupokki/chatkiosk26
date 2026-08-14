package io.github.cupokki.chatkiosk26.store.repository;

import io.github.cupokki.chatkiosk26.order.entity.Menu;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public record Store(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        String name,

        List<Menu> menus

) {
}

package io.github.cupokki.chatkiosk26.Tag;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public record Tag(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        String name,

        List<Float> vector
) {

}

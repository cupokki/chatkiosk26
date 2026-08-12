package io.github.cupokki.chatkiosk26.order.entity;

import io.github.cupokki.chatkiosk26.category.entity.Category;
import io.github.cupokki.chatkiosk26.common.Tag;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public record Product(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,

        String name,

        BigDecimal price,

        String description,

        @Enumerated(EnumType.STRING)
        List<Tag> tags,

        Boolean available,

        @OneToOne(mappedBy = "category_id")
        Category category

) {
}

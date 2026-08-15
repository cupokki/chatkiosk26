package io.github.cupokki.chatkiosk26.Menu;

import io.github.cupokki.chatkiosk26.category.Category;
import io.github.cupokki.chatkiosk26.common.base.BaseEntity;
import io.github.cupokki.chatkiosk26.store.Store;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Entity
@Getter
@Builder
public class Menu extends BaseEntity {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;

        String name;

        @OneToOne(fetch = FetchType.LAZY)
        Store store;

        @OneToOne(fetch = FetchType.LAZY)
        Category category;

        BigDecimal price;

        String description;

        Boolean available;
}

package io.github.cupokki.chatkiosk26.menu;

import io.github.cupokki.chatkiosk26.category.Category;
import io.github.cupokki.chatkiosk26.common.base.BaseEntity;
import io.github.cupokki.chatkiosk26.store.Store;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

        @OneToMany(cascade = CascadeType.ALL)
        List<MenuTag> tags = new ArrayList<>();

        BigDecimal price;

        String description;

        Boolean available;
}

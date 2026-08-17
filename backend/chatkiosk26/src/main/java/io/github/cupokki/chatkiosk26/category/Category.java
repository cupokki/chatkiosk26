package io.github.cupokki.chatkiosk26.category;

import io.github.cupokki.chatkiosk26.common.base.BaseEntity;
import io.github.cupokki.chatkiosk26.store.Store;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
public class Category extends BaseEntity {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;

        String name;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "store_id")
        Store store;

//        Integer displayOrder;
}

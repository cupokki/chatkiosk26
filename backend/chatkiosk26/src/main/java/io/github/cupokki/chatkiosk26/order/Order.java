package io.github.cupokki.chatkiosk26.order;

import io.github.cupokki.chatkiosk26.common.base.BaseEntity;
import io.github.cupokki.chatkiosk26.store.Store;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Builder
public class Order extends BaseEntity {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;

        @OneToOne(fetch = FetchType.LAZY)
        Store store;

//        @OneToMany(mappedBy = "order_item_id")
        @OneToMany(fetch = FetchType.LAZY)
        List<OrderItem> orderItems;

        String status;

        LocalDateTime orderedAt;

}

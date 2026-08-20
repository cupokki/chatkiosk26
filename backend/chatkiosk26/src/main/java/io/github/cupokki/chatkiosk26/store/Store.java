package io.github.cupokki.chatkiosk26.store;

import io.github.cupokki.chatkiosk26.common.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Store extends BaseEntity {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;

        String name;

//        String code;
//        String address;
//        String status;
//        String address;


//        @ManyToOne(fetch = FetchType.LAZY)
//        @JoinColumn(name = "menu_id")
//        List<Menu> menus;

}

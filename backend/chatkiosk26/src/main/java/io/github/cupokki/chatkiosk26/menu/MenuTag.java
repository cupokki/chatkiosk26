package io.github.cupokki.chatkiosk26.menu;

import io.github.cupokki.chatkiosk26.tag.Tag;
import io.github.cupokki.chatkiosk26.common.base.BaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
public class MenuTag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany
    Menu menu;

    @OneToMany
    Tag tag;

}

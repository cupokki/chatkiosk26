package io.github.cupokki.chatkiosk26.category;

import io.github.cupokki.chatkiosk26.common.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
public class Category extends BaseEntity {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;

        String name;
}

package io.github.cupokki.chatkiosk26.common.base;

import jakarta.persistence.EntityListeners;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    LocalDateTime createAt;

    @LastModifiedDate
    LocalDateTime updatedAt;

    LocalDateTime deletedAt;

}

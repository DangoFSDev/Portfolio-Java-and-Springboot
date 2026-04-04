package com.ecos.infrastructure.entity;

import java.time.Instant;

import jakarta.persistence.Column;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
public class BaseTimestampedEntity {

    @CreationTimestamp
    @Column(name = "create_date", nullable = false, updatable = false)
    private Instant createDate;

    @UpdateTimestamp
    @Column(name = "update_date", nullable = false)
    private Instant updateDate;

}

package com.ecos.infrastructure.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "orders")
@Getter
@Data
@Builder
public class OrderEntity extends BaseTimestampedEntity implements BaseEntity {

    @Id
    private Long id;

}

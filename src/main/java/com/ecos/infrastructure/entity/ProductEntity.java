package com.ecos.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.ecos.domain.valueobjects.Money;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "products")
@Getter
@Data
@Builder
public class ProductEntity extends BaseTimestampedEntity implements BaseEntity {

    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Money price;

    @Column(name = "stock", nullable = false)
    private int stock;

    @Column(name = "isActive", nullable = false)
    private Boolean isActive;

}

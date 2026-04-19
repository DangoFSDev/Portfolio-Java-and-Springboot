package com.ecos.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "orders", schema = "ecos")
@Getter
@Data
public class OrderEntity extends BaseTimestampedEntity implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq_gen")
    @SequenceGenerator(sequenceName = "order_seq", name = "order_seq_gen", allocationSize = 1, schema = "ecos")
    private Long id;

    @Column(name = "order_id", nullable = false, unique = true)
    private String orderId;

    @Column(name = "product_code", nullable = false)
    private String productCode;

    @Column(name = "user_id", nullable = false)
    private Long userId;

}

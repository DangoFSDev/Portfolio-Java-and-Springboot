package com.ecos.infrastructure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "products", schema = "ecos")
@Getter
@Setter
@Data
public class ProductEntity extends BaseTimestampedEntity implements BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq_gen")
    @SequenceGenerator(sequenceName = "product_seq", name = "product_seq_gen", allocationSize = 1, schema = "ecos")
    private Long id;


    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "desc")
    private String desc;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

}

package com.ecos.infrastructure.repository;

import com.ecos.infrastructure.entity.OrderEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<OrderEntity, Long> {

}

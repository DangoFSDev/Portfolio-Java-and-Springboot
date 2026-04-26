package com.ecos.infrastructure.repository;

import com.ecos.infrastructure.entity.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUserId(Long userId);

    UserEntity findByUserName(String username);

    void deleteByUserId(Long userId);

}

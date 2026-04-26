package com.ecos.infrastructure.persistence;

import java.util.Optional;

import com.ecos.domain.model.User;
import com.ecos.domain.repository.UserRepository;
import com.ecos.infrastructure.entity.UserEntity;
import com.ecos.infrastructure.mapper.UserMapper;
import com.ecos.infrastructure.repository.UserJPARepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJPARepository jpaRepository;
    private final UserMapper mapper;

    @Override
    public User getUser(Long userId) {

        return mapper.fromEntityToDto(jpaRepository.findByUserId(userId));
    }

    @Override
    public User saveUser(User user) {

        UserEntity entity = mapper.toEntity(user);
        return mapper.fromEntityToDto(jpaRepository.saveAndFlush(entity));
    }

    @Override
    public void deleteUser(User user) {

        jpaRepository.deleteByUserId(user.getUserId());
    }

    @Override
    public User findExistingUser(Long id) {

        return jpaRepository.findById(id)
                            .map(mapper::fromEntityToDto)
                            .orElse(null);
    }

    @Override
    public Optional<User> findByUsername(String username) {

        return Optional.ofNullable(mapper.fromEntityToDto(jpaRepository.findByUserName(username)));
    }

}

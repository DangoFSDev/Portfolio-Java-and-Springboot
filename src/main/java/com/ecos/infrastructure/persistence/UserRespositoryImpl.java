package com.ecos.infrastructure.persistence;

import java.util.Optional;

import com.ecos.domain.model.User;
import com.ecos.domain.repository.UserRepository;
import com.ecos.infrastructure.mapper.UserMapper;
import com.ecos.infrastructure.repository.UserJPARepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRespositoryImpl implements UserRepository {

    private final UserJPARepository jpaRepository;
    private final UserMapper mapper;

    // TODO: Implementation
    @Override
    public User save(User user) {

        return null;
    }

    @Override
    public Optional<User> findByUsername(String username) {

        return Optional.empty();
    }

}

package com.ecos.domain.repository;

import java.util.Optional;

import com.ecos.domain.model.User;

public interface UserRepository {

    User save(User user);

    Optional<User> findByUsername(String username);

}

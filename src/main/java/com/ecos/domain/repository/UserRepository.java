package com.ecos.domain.repository;

import java.util.Optional;

import com.ecos.domain.model.User;

public interface UserRepository {

    User getUser(Long userId);

    User saveUser(User user);

    void deleteUser(User user);

    User findExistingUser(Long id);

    Optional<User> findByUsername(String username);

}

package com.ecos.application.usecase;

import com.ecos.application.dto.request.UserRequest;
import com.ecos.application.dto.response.UserResponse;
import com.ecos.domain.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUseCase {

    // TODO: implementation
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse getUser(Long userId) {

        return null;
    }

    public UserResponse addUser(UserRequest request) {

        return null;
    }

    public UserResponse updateUser(UserRequest request) {

        return null;
    }

    public UserResponse deleteUser(UserRequest request) {

        return null;
    }

}

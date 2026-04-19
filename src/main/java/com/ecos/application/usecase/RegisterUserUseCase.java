package com.ecos.application.usecase;

import com.ecos.application.dto.request.UserRequest;
import com.ecos.application.dto.response.UserResponse;
import com.ecos.domain.model.User;
import com.ecos.domain.repository.UserRepository;
import com.ecos.infrastructure.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterUserUseCase {

    // TODO: implementation
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserResponse registerNewUser(UserRequest request) {

        String hashedPassword = passwordEncoder.encode(request.getPassword());

        User user = User.builder()
                        .password(hashedPassword)
                        .build();

        return userMapper.toResponse(userRepository.save(user));
    }

}
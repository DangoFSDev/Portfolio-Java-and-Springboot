package com.ecos.application.usecase;

import com.ecos.application.dto.request.UserRequest;
import com.ecos.application.dto.response.UserResponse;
import com.ecos.domain.exception.InvalidPasswordException;
import com.ecos.domain.model.User;
import com.ecos.domain.repository.UserRepository;
import com.ecos.infrastructure.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserResponse loginUser(UserRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                                  .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        boolean matches = passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        );

        if (!matches) {
            throw new InvalidPasswordException("Invalid credentials");
        }

        // proceed (JWT later)

        return userMapper.toResponse(user);
    }

}

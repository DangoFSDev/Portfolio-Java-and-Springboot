package com.ecos.application.usecase;

import java.util.Optional;

import com.ecos.application.dto.request.UserRequest;
import com.ecos.application.dto.response.UserResponse;
import com.ecos.domain.exception.DomainException;
import com.ecos.domain.model.User;
import com.ecos.domain.repository.UserRepository;
import com.ecos.infrastructure.mapper.UserMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUseCase {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Cacheable(value = "getUser", key = "#userId")
    public UserResponse getUser(Long userId) {

        return userMapper.toResponse(userRepository.getUser(userId));
    }

    public UserResponse addUser(UserRequest request) {

        User dto = userMapper.fromRequestToDto(request);
        Optional<User> existingUser = userRepository.findByUsername(dto.getUserName());

        if (existingUser.isPresent()) {
            throw new DomainException("Existing user found: " + dto.getUserName());
        }

        dto.setPassword(passwordEncoder.encode(request.getPassword()));

        return userMapper.toResponse(userRepository.saveUser(dto));
    }

    @CacheEvict(value = "getUser", key = "#request.userId")
    public UserResponse updateUser(UserRequest request) {

        User dto = userMapper.fromRequestToDto(request);
        User existingUser = userRepository.findExistingUser(dto.getUserId());

        if (existingUser == null) {
            throw new DomainException("User not found with id: " + dto.getUserId());
        }
        
        dto.setPassword(passwordEncoder.encode(request.getPassword()));

        return userMapper.toResponse(userRepository.saveUser(dto));
    }

    @CacheEvict(value = "getUser", key = "#request.userId")
    public UserResponse deleteUser(UserRequest request) {

        User dto = userMapper.fromRequestToDto(request);
        User existingUser = userRepository.findExistingUser(dto.getUserId());

        if (existingUser == null) {
            throw new DomainException("User not found with id: " + dto.getUserId());
        }

        userRepository.deleteUser(dto);

        return null;
    }

}

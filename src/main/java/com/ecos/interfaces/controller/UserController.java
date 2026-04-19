package com.ecos.interfaces.controller;


import com.ecos.application.dto.request.UserRequest;
import com.ecos.application.dto.response.UserResponse;
import com.ecos.application.usecase.LoginUseCase;
import com.ecos.application.usecase.RegisterUserUseCase;
import com.ecos.application.usecase.UserUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserUseCase userUseCase;
    private final RegisterUserUseCase registerUserUseCase;
    private final LoginUseCase loginUseCase;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable("userId") Long userId) {

        return ResponseEntity.ok(userUseCase.getUser(userId));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerNewUser(@RequestBody UserRequest request) {

        return ResponseEntity.ok(registerUserUseCase.registerNewUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody UserRequest request) {

        return ResponseEntity.ok(loginUseCase.loginUser(request));
    }

    @PostMapping("/add")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest request) {

        return ResponseEntity.ok(userUseCase.addUser(request));
    }

    @PutMapping("/update")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest request) {

        return ResponseEntity.ok(userUseCase.updateUser(request));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<UserResponse> deleteUser(@RequestBody UserRequest request) {

        return ResponseEntity.ok(userUseCase.deleteUser(request));
    }

}

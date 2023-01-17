package com.clean.database.demo.adapter.controller;

import com.clean.database.demo.entity.User;
import com.clean.database.demo.service.in.CreateUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class CreateUserController {
    private final CreateUserUseCase createUserUseCase;

    @PostMapping("")
    public User createUser(@RequestBody User userEntity) {
        return createUserUseCase.createUser(userEntity);
    }

}

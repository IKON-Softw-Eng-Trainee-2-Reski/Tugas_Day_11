package com.clean.database.demo.adapter.controller;
import com.clean.database.demo.entity.User;
import com.clean.database.demo.service.in.GetAllUserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/user")
@RequiredArgsConstructor
public class GetUserController {
    private final GetAllUserUseCase getAllUserUseCase;
    @GetMapping
    public List<User> getAllUser() {
        return getAllUserUseCase.getAllUser();
    }

}

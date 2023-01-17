package com.clean.database.demo.service;

import com.clean.database.demo.entity.User;
import com.clean.database.demo.service.in.CreateUserUseCase;
import com.clean.database.demo.service.out.CreateUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService implements CreateUserUseCase {
    private final CreateUserPort createUserPort;
    @Override
    public User createUser(User userEntity) {
        return createUserPort.createUser(userEntity);
    }

}

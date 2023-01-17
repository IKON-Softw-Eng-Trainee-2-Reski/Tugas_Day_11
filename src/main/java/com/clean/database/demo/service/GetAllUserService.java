package com.clean.database.demo.service;

import com.clean.database.demo.entity.User;
import com.clean.database.demo.service.in.GetAllUserUseCase;
import com.clean.database.demo.service.out.GetAllUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllUserService implements GetAllUserUseCase {
    private final GetAllUserPort getAllUserPort;

    @Override
    public List<User> getAllUser() {
        return getAllUserPort.getAllUser();
    }
}

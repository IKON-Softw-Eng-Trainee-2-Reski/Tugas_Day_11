package com.clean.database.demo.adapter.persistence;
import com.clean.database.demo.entity.User;
import com.clean.database.demo.service.out.CreateUserPort;
import com.clean.database.demo.service.out.GetAllUserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class UserPersistence implements GetAllUserPort, CreateUserPort{
    private final UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User userEntity) {
        return userRepository.save(userEntity);
    }


}

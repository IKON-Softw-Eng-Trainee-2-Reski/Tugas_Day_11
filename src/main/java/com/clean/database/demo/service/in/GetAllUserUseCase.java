package com.clean.database.demo.service.in;
import com.clean.database.demo.entity.User;

import java.util.List;

public interface GetAllUserUseCase {
    List<User> getAllUser();
}

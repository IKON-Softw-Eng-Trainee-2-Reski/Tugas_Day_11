package com.clean.database.demo.adapter.persistence;
import com.clean.database.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

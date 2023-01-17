package com.clean.database.demo;

import com.clean.database.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.clean.database.demo")
public class LibraryApplication {
  @Autowired
  private UserRepository userRepository;

  public static void main(String[] args) {
    SpringApplication.run(LibraryApplication.class, args);
  }
}

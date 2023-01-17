package com.clean.database.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="email")
    private String email;

    @Column(name="pasword")
    private String pasword;

    public User(int id, String email, String pasword) {
        this.id = id;
        this.email = email;
        this.pasword = pasword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPassword(String pasword) {
        this.pasword = pasword;
    }
}

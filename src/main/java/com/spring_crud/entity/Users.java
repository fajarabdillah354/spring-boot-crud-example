package com.spring_crud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "user_username"),
                @UniqueConstraint(columnNames = "user_email")
        }
)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    @Column(name = "user_email", nullable = false)
    @Size(max = 50, message = "email cannot up to 50 char")
    private String email;

    @NotBlank
    @Column(name = "user_username", nullable = false)
    @Size(max = 50, message = "username cannot up to 50 char")
    private String username;

    @NotBlank
    @Column(name = "user_password", nullable = false)
    @Size(max = 50, message = "password cannot up to 50 char")
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

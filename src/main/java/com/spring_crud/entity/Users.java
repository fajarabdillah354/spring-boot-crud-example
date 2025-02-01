package com.spring_crud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();


}

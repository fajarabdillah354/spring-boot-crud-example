package com.spring_crud.models.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


import java.util.Set;




public class SignupRequest {

    @Email(message = "must be @gmail")
    @NotBlank(message = "email cannot blank")
    @Size(max = 50, message = "email cannot up to 50 char")
    private String email;

    @NotBlank(message = "username cannot blank")
    @Size(max = 50, message = "username cannot up to 50 char")
    private String username;

    @NotBlank(message = "password cannot blank")
    @Size(max = 50, message = "password cannot up to 50 char")
    private String password;

    private Set<String> role;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}

package com.spring_crud.models.payload.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


public class LoginRequest {

    public LoginRequest(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public LoginRequest() {
    }

    @NotBlank(message = "username cannot not blank")
    @Size(min = 8, max = 20)
    private String username;

    @NotBlank
    @Size(min = 8, max = 25)
    private String password;

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

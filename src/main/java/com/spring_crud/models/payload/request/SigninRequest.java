package com.spring_crud.models.payload.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class SigninRequest {

    public SigninRequest(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public SigninRequest() {
    }

    @NotBlank(message = "username cannot blank")
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank(message = "password cannot blank")
    @Size(min = 4, max = 25)
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

package com.spring_crud.models.payload.response;



public class SigninResponse {

    private String token;

    private Long expiredIn;

    public SigninResponse() {
    }

    public Long getExpiredIn() {
        return expiredIn;
    }

    public void setExpiredIn(Long expiredIn) {
        this.expiredIn = expiredIn;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

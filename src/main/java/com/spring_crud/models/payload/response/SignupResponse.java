package com.spring_crud.models.payload.response;

import com.spring_crud.SpringBootCrudApplication;
import com.spring_crud.models.entity.UserEntity;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
public class SignupResponse {

    private String email;

    private String username;

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

    //agar dalam postman bisa menampilkan data dari Enum Rolenya

    /**
     * kita membuat constructor baru dengan parameter nya UserEntity
     * lalu kita inisiasikan semua field this. ke var UserEntity.get... / UserEntity.get..
     * lalu kuncinya adalah .map(roleEntity -> roleEntity.getName().name()  yang diinisiasikan di variable role
     */
    public SignupResponse(UserEntity user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.role = user.getRoleEntities().stream()
                .map(roleEntity -> roleEntity.getName().name())
                .collect(Collectors.toSet());
    }
}

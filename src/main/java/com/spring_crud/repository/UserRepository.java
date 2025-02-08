package com.spring_crud.repository;


import com.spring_crud.models.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByUsername(String name);

    Boolean existsByUsername(String name);

    Boolean existsByEmail(String email);

}

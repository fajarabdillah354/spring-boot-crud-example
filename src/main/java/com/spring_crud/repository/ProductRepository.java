package com.spring_crud.repository;

import com.spring_crud.models.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    @Modifying
    @Query("SELECT pr FROM ProductEntity pr WHERE pr.productName = :name")
    List<ProductEntity> findByProductName(@Param("name") String name);


}

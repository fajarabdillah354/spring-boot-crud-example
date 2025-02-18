package com.spring_crud.models.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;


@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class ProductEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_quantity")
    private Integer productQuantity;

    @Column(name = "product_price")
    private Integer productPrice;

    @CreationTimestamp
    @Column(name = "product_created")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "product_updated")
    private Date updatedAt;


}

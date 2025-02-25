package com.spring_crud.models.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String customerId;

    @Column(name = "name")
    private String customerName;

    @Column(name = "email")
    private String customerEmail;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;


    @OneToOne(cascade = CascadeType.ALL)
    private AddressesEntity addresses;

    @OneToOne(cascade = CascadeType.ALL)
    private OrderEntity order;


}

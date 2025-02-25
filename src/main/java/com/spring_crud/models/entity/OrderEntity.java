package com.spring_crud.models.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String orderId;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @Column(name = "total_amount")
    private Float totalAmount;



}

package com.spring_crud.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class ProductDto {


    @NotNull(message = "product name cannot null")
    @NotBlank(message = "product name cannot blank")
    private String productName;


    @NotNull(message = "product description cannot null")
    @NotBlank(message = "product description cannot blank")
    private String productDescription;


    @NotNull(message = "product quantity cannot null")
    @NotBlank(message = "product quantity cannot blank")
    private Integer productQuantity;


    @NotNull(message = "product price cannot null")
    @NotBlank(message = "product price cannot blank")
    private Integer productPrice;


    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }
}

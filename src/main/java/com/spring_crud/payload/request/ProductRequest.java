package com.spring_crud.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class ProductRequest {

    @NotBlank(message = "product name cannot blank")
    private String productName;

    @NotBlank(message = "product description cannot blank")
    private String productDescription;

    @NotBlank(message = "product quantity cannot blank")
    private Integer productQuantity;

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

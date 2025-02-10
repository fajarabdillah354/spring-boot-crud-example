package com.spring_crud.controller;


import com.spring_crud.models.dto.ProductDto;
import com.spring_crud.models.entity.ProductEntity;
import com.spring_crud.models.payload.request.ProductRequest;
import com.spring_crud.models.payload.response.BaseResponse;
import com.spring_crud.models.payload.response.ProductResponse;
import com.spring_crud.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //GET ALL PRODUCT
    @GetMapping("/products")
    public List<ProductEntity> getProducts(){
        return productService.productList();
    }

    //GET PRODUCT BY NAME
    @GetMapping("/{name}")
    public List<ProductEntity> getProductByName(@PathVariable String name){
        return productService.getAllProductByName(name);
    }

    //CREATED NEW PRODUCT
    @PostMapping("/create")
    public ResponseEntity<BaseResponse<ProductResponse>> createProduct(@Valid @RequestBody ProductRequest productRequest){
        ProductResponse response = productService.create(productRequest);

        BaseResponse<ProductResponse> baseResponse = new BaseResponse<>();
        baseResponse.setSuccess(true);
        baseResponse.setMessage("Product add success");
        baseResponse.setData(response);

        return ResponseEntity.status(HttpStatus.CREATED).body(baseResponse);

    }


    //UPDATE PRODUCT
    @PutMapping("/update/{id}")
    public ResponseEntity<ProductEntity> updatedProduct(@PathVariable("id") String id, @Valid @RequestBody ProductDto productDto){
        return productService.updated(id, productDto);
    }



    //DELETED PRODUCT
    @DeleteMapping("/deleted/{id}")
    public ResponseEntity<Void> deletedProduct(@PathVariable("id") String id){
        return productService.deleted(id);
    }


    // HANDLER THEN ERROR
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handler(MethodArgumentNotValidException exception){

        var errors = new HashMap<String, String>();
        exception.getBindingResult().getAllErrors()
                .forEach(objectError -> {
                    String fieldName = ((FieldError) objectError).getField();
                    String errorMessage = objectError.getDefaultMessage();

                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);


    }




}

package com.spring_crud.service;


import com.spring_crud.models.dto.ProductDto;
import com.spring_crud.models.entity.ProductEntity;
import com.spring_crud.models.payload.request.ProductRequest;
import com.spring_crud.models.payload.response.ProductResponse;
import com.spring_crud.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {


    //INJECT Repository and ModelMapper
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;


    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }


    public List<ProductEntity> productList(){
        return productRepository.findAll();
    }

    public List<ProductEntity> getAllProductByName(String name){
        return productRepository.findByProductName(name);
    }


    @Transactional
    public ProductResponse create(ProductRequest productRequest){
        ProductEntity productEntity = modelMapper.map(productRequest, ProductEntity.class);
        productEntity.setProductName(productRequest.getProductName());
        productEntity.setProductDescription(productRequest.getProductDescription());
        productEntity.setProductQuantity(productRequest.getProductQuantity());
        productEntity.setProductPrice(productRequest.getProductPrice());

        ProductEntity saved = productRepository.save(productEntity);

        return modelMapper.map(saved, ProductResponse.class);

    }


    @Transactional
    public ResponseEntity<ProductEntity> updated(String id, ProductDto productDto){
        return productRepository.findById(id)
                .map(productEntity -> {
                    productEntity.setProductName(productDto.getProductName());
                    productEntity.setProductDescription(productDto.getProductDescription());
                    productEntity.setProductPrice(productDto.getProductPrice());
                    productEntity.setProductQuantity(productDto.getProductQuantity());

                    modelMapper.map(productEntity, ProductDto.class);
                    return ResponseEntity.ok(productRepository.save(productEntity));
                }).orElse(ResponseEntity.notFound().build());
    }


    @Transactional
    public ResponseEntity<Void> deleted(String id){
        Optional<ProductEntity> optionalProducts = productRepository.findById(id);
        if (optionalProducts.isPresent()){

            productRepository.delete(optionalProducts.get());
        }else {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();

    }







}

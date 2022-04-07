package com.example.service;

import com.example.exception.HttpError;
import com.example.exception.NotFoundException;
import com.example.repository.ProductEntity;
import com.example.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/*

    HTTP Methods
    -------------------

    READ operations

        - GET

        - HEAD

        - OPTION -> to know privileges/permissions 'user/client' has on that resource

    WRITE operations

        - POST
            -> to create 'unknown' resource
            -> to do 'control' operations , e.g login,register,transfer,...
        - PUT
            -> to create/update 'known' resource

        - PATCH
            -> to do partial update of 'known' resource

       - DELETE
            -> to delete existing resource

 */

//@Service
@RestController
@Transactional
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    @RequestMapping(method = RequestMethod.GET, value = "/api/product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable int id) {
        Optional<ProductEntity> optional = productRepository.findById(id);
        ProductEntity productEntity = optional.orElseThrow(() -> new NotFoundException("not found"));
        return ResponseEntity.status(200).body(productEntity);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/product")
    public ResponseEntity<?> createProduct(@RequestBody ProductEntity productEntity) {
        ProductEntity entity = productRepository.save(productEntity);
        return ResponseEntity.status(201).body(entity);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/product/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id) {
        productRepository.deleteById(id);
        return ResponseEntity.status(204).build();
    }


}

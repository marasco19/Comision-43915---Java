package com.coderhouse.Clase8JPAABM.controller;

import com.coderhouse.Clase8JPAABM.middleware.ResponseHandler;

import com.coderhouse.Clase8JPAABM.model.Product;
import com.coderhouse.Clase8JPAABM.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    //Create a Product
    @PostMapping
    public ResponseEntity<Object> postProduct (@RequestBody Product product) {
        try {
            System.out.println(product);
            Product productSaved = productService.postProduct(product);
            return ResponseHandler.generateResponse(
                    "Product stored successfully",
                    HttpStatus.OK,
                    productSaved
            );
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null
            );
        }
    }
    //Get a Product
    @GetMapping(path = "{id}")
    public ResponseEntity<Object> getProduct (@PathVariable() int id) {
        try {
            System.out.println(id);
            Product productFound = productService.getProduct(id);
            System.out.println("Producto encontrado: " + productFound);
            if(productFound != null) {
                return ResponseHandler.generateResponse(
                        "Product get successfully",
                        HttpStatus.OK,
                        productFound);
            }else{
                return ResponseHandler.generateResponse(
                        "Product dont exists",
                        HttpStatus.BAD_REQUEST,
                        "No existe Producto");
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        }

    }

}
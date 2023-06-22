package com.coderhouse.Clase8JPAABM.controller;

import com.coderhouse.Clase8JPAABM.middleware.ResponseHandler;

import com.coderhouse.Clase8JPAABM.model.Product;
import com.coderhouse.Clase8JPAABM.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping
    public ResponseEntity<Object> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        if (!products.isEmpty()) {
            return ResponseHandler.generateResponse(
                    "Product get successfully",
                    HttpStatus.OK,
                    products);
        } else {
            return ResponseHandler.generateResponse(
                    "Products doesnt exists",
                    HttpStatus.OK,
                    null);
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
                        "Product doesnt exists",
                        HttpStatus.OK,
                        null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse(
                    e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    null);
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct != null) {
            return ResponseHandler.generateResponse(
                    "Product updated successfully",
                    HttpStatus.OK,
                    updatedProduct);
        } else {
            return ResponseHandler.generateResponse(
                    "Product dont exists",
                    HttpStatus.BAD_REQUEST,
                    "No existe Producto");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable int id) {
        Product deletedProduct = productService.deleteProduct(id);
        if (deletedProduct != null) {
            return ResponseHandler.generateResponse(
                    "Product deleted successfully",
                    HttpStatus.OK,
                    deletedProduct);
        } else {
            return ResponseHandler.generateResponse(
                    "Product dont exists",
                    HttpStatus.BAD_REQUEST,
                    "No existe Producto");
        }
    }

    private boolean validarTiposDeDatos(Product product) {
        /*int document = product.getDocnumber();
        // Validar si es numérico
        String numeroDocumentoString = String.valueOf(document);
        if (!numeroDocumentoString.matches("\\d+")) {
            return false; // El campo NumeroDocumento no es numérico
        }
        if (client.getName() == null || client.getName().isEmpty()) {
            return false;
        }
        if (client.getLastname() == null || client.getLastname().isEmpty()) {
            return false;
        }
        */
        // Si todas las validaciones pasan, retornar true
        return true;
    }

}
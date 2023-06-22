package com.coderhouse.Clase8JPAABM.service;


import com.coderhouse.Clase8JPAABM.model.Product;
import com.coderhouse.Clase8JPAABM.model.Client;
import com.coderhouse.Clase8JPAABM.model.RequestProductDetail;
import com.coderhouse.Clase8JPAABM.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product postProduct(Product product) throws Exception {
        return productRepository.save(product);
    }

    public Product getProduct(int id) throws Exception {
        Optional<Product> producto = productRepository.findById(id);
        if(producto.isEmpty()){
            return null;
        } else {
            return producto.get();
        }
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public List<Product> getProductsById(List<RequestProductDetail> productListId) throws Exception {
        List<Product> productList = new ArrayList<>();
        for (RequestProductDetail requestProduct:
                productListId) {
            Optional<Product> productFound = productRepository.findById(requestProduct.getProductId());
            if (productFound.isEmpty()){
                throw new Exception("Product with id: " + requestProduct.getProductId() + " not found.");
            }
            productList.add(productFound.get());
        }
        return productList;
    }

    public Product updateProduct(int id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setTitle(product.getTitle());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setCode(product.getCode());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setStock(product.getStock());
            return productRepository.save(existingProduct);
        } else {
            return null;
        }
    }

    public void updateStock(Product product) {
       productRepository.save(product);
    }

    public Product deleteProduct(int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            productRepository.delete(product);
            return product;
        } else {
            return null;
        }
    }





}
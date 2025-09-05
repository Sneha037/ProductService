package org.example.productservice.Services;

import org.example.productservice.Models.Category;
import org.example.productservice.Models.Product;
import org.springframework.stereotype.Service;
import org.example.productservice.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService
{
    Product getSingleProduct(String ID) throws ProductNotFoundException;

    Product createProduct(String title, String description, double price, Category category, String image);

    List<Product> getAllProducts();


}

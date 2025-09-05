package org.example.productservice.Controllers;
import lombok.Getter;
import lombok.Setter;
import org.example.productservice.DTOs.ProductNotFoundErrorDTO;
import org.example.productservice.DTOs.ProductRequestDTO;
import org.example.productservice.Models.Category;
import org.example.productservice.Models.Product;
//import org.example.productservice.Models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.productservice.Services.ProductService;
import java.util.List;
import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.example.productservice.Repository.CategoryRepository;

import org.example.productservice.exceptions.ProductNotFoundException;

@Getter
@Setter
@RestController
@RequestMapping("/products")
public class ProductController
{
    // This class is the entry point of requests

    //Get Product Details
    // Get All Products
    // Update products

    //Create Product
    //Delete Product
    //@Qualifier

    private ProductService productService;
    @Autowired
    private CategoryRepository categoryRepository;

   ProductController(@Qualifier("selfproductservice")
                     ProductService productService)
    {
        this.productService = productService;
    }

    @GetMapping("/{ID}")
    ResponseEntity<Product> getSingleProduct(@PathVariable("ID") Long ID) throws ProductNotFoundException
    {
        // call service layer to get the product
        Product product = productService.getSingleProduct(ID);

        if(product == null)
            return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);

        return ResponseEntity.ok(product);
    }

    @GetMapping
    List<Product>  getAllProducts()
    {
        return productService.getAllProducts();
    }

    @PostMapping
    Product createProduct(@RequestBody ProductRequestDTO  productRequestDTO)
    {
        if(categoryRepository.findByName(productRequestDTO.getCategory()) == null)
        {
            Category category = new Category();
            category.setName(productRequestDTO.getCategory());
            categoryRepository.save(category);
        }


          return productService.createProduct(
                  productRequestDTO.getTitle(),
                  productRequestDTO.getDescription(),
                  productRequestDTO.getPrice(),
                  categoryRepository.findByName(productRequestDTO.getCategory()),
                  productRequestDTO.getImage()
          );
    }

    /*
    We got an  exception, and we don't want to send the stack trace to the client
    1. We can handle the exception in the controller method itself
    2. We can have a global exception handler using @ControllerAdvice
    3. We can have a local exception handler using @ExceptionHandler
     */

}

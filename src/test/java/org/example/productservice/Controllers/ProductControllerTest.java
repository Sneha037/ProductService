package org.example.productservice.Controllers;

import org.example.productservice.Models.Product;
import org.example.productservice.Services.ProductService;
import org.example.productservice.exceptions.ProductNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest
{
    /* @Autowired - This will not work as the class has not been annotated. In Spring, we will have to annotate classes
                    as @Component, @Controller or anything else for Spring to recognise these classes
                    We annotate the class here as @SpringBootTest
     */
    @Autowired
    private ProductController productController;

    @MockitoBean
    private ProductService productService;

    @Test
     void testGetSingleProduct() throws ProductNotFoundException
     {
         //A -->Arrange
            Long productId = 10L;

            Product expectedProduct = new Product();

            when(productService.getSingleProduct(productId))
                    .thenReturn(expectedProduct);

         //A --> Act
           Product product = productController.getSingleProduct(productId).getBody();

         //A --> Assert
           assertEquals(expectedProduct,product);

     }

     /*@Test
     public void testSample()
     {
         int a = 10;
         int b = 20;

         int result = a+b;

         assertEquals(30,result);

     }*/
}

//Test case is nothing but a method that tests a particular functionality and can get executed automatically
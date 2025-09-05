package org.example.productservice.Services;

import org.example.productservice.DTOs.FakeStoreProductDTO;
import org.example.productservice.Models.Category;
import org.example.productservice.Models.Product;
import org.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.example.productservice.exceptions.ProductNotFoundException;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService
{
    //To call external APIs, we can use RestTemplate dependencies
    //To call 3rd party APIs, need RestTemplate

    // for all internal spring dependency, if you want to inject their object, you need to define their configurations

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate template) {
        this.restTemplate = template;
    }

    @Override
    public Product getSingleProduct(String ID) throws ProductNotFoundException
    {
        FakeStoreProductDTO  fakeStoreProductResponse = restTemplate.getForObject("https://fakestoreapi.com/products/" + ID, FakeStoreProductDTO.class);

        if(fakeStoreProductResponse == null)
            throw new ProductNotFoundException("Product with ID " + ID + " not found");

        return fakeStoreProductResponse.toProduct();
    }

    @Override
    public Product createProduct(String title, String description, double price, Category category, String image)
    {
        return null;
    }

    @Override
    public List<Product> getAllProducts()
    {
        return null;
    }
}

package org.example.productservice.Services;

import org.example.productservice.DTOs.FakeStoreProductDTO;
import org.example.productservice.Models.Category;
import org.example.productservice.Models.Product;
import org.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.example.productservice.exceptions.ProductNotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("fakestoreproductservice")
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
    public Product getSingleProduct(Long ID) throws ProductNotFoundException
    {
        FakeStoreProductDTO  fakeStoreProductResponse = restTemplate.getForObject("https://fakestoreapi.com/products/" + ID, FakeStoreProductDTO.class);

        if(fakeStoreProductResponse == null || fakeStoreProductResponse.getID() == null) {
            throw new ProductNotFoundException("Product with ID " + ID + " not found");
           // return null;
        }

        return fakeStoreProductResponse.toProduct();
    }

    @Override
    public Product createProduct(String title, String description, double price, Category category, String image) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();

        fakeStoreProductDTO.setTitle(title);
        fakeStoreProductDTO.setDescription(description);
        fakeStoreProductDTO.setPrice(price);
        fakeStoreProductDTO.setCategory(category.getName());
        fakeStoreProductDTO.setImage(image);

        return fakeStoreProductDTO.toProduct();
    }

    @Override
    public List<Product> getAllProducts()
    {
        FakeStoreProductDTO[] fakeStoreProductResponse = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);

        List<FakeStoreProductDTO> fakeStoreProductDTOList = Arrays.asList(fakeStoreProductResponse);

        List<Product> response = new ArrayList<>();

        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOList)
        {
            Product product = fakeStoreProductDTO.toProduct();
            response.add(product);
        }

        return response;
    }
}

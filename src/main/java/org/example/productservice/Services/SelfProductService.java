package org.example.productservice.Services;

import org.example.productservice.DTOs.ProductRequestDTO;
import org.example.productservice.Models.Category;
import org.example.productservice.Models.Product;
import org.example.productservice.Repository.CategoryRepository;
import org.example.productservice.Repository.ProductRepository;
import org.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfproductservice")
public class SelfProductService implements ProductService
{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;


    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository)
    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long ID) throws ProductNotFoundException
    {
        return null;
    }

    @Override
    public Product createProduct(String title, String description, double price, Category category, String image)
    {
        Product p = new Product();
        p.setTitle(title);
        p.setDescription(description);
        p.setPrice(price);
        p.setImage(image);
        p.setCategory(category);

        //Optional<Category> c =  categoryRepository.findById(category.getID());

        /* (This logic is shifted to controller)
        Category c = categoryRepository.findByName(category.getName());

        if(c == null)
        {
            c = new Category();
            c.setName(category.getName());
            categoryRepository.save(c);
            p.setCategory(c);
        }
        else
        {
            p.setCategory(category);
        }
        */

        productRepository.save(p);
        return p;
    }

    @Override
    public List<Product> getAllProducts()
    {
        return List.of();
    }
}

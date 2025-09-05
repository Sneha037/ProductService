package org.example.productservice.DTOs;

import org.example.productservice.Models.Category;
import org.example.productservice.Models.Product;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO
{
    private String ID;

    private String Title;
    private String Description;

    private double Price;

    private String Category;

    private String Image;

    public Product toProduct()
    {
        Product product = new Product();

        product.setID(this.ID);

        product.setTitle(this.Title);
        product.setDescription(this.Description);
        product.setPrice(this.Price);
        product.setImage(this.Image);

        Category category = new Category();
        category.setName(this.Category);

        product.setCategory(category);

        return product;
    }
}

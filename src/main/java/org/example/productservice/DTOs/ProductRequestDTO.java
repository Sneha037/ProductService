package org.example.productservice.DTOs;
//import org.example.productservice.models.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequestDTO
{
    private String title;
    private String name;
    private String description;
    private String image;
    private double price;
    private String category;
}

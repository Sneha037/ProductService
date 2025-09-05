package org.example.productservice.Models;
import org.example.productservice.Models.Category;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String ID;
    private String Title;
    private String Name;
    private String Image;
    private String Description;
    private double Price;
    private Category Category;
}

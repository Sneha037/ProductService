package org.example.productservice.Models;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.example.productservice.Models.Category;



@Getter
@Setter
@Entity//
public class Product extends BaseModel
{
    //private String ID;
    private String Title;
    private String Name;
    private String Image;
    private String Description;
    private double Price;
    //Has-A relationship. We have to provide a cardinality annotation
    @ManyToOne
    private Category Category;
}

package org.example.productservice.Models;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Getter
@Setter
//@SpringBootApplication

@Entity
public class Category extends BaseModel
{
    //private String ID;
    private String name;


}

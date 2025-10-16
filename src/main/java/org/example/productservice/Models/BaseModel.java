package org.example.productservice.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
//To tell Spring that this is not a model, but a superclass to keep the audit fields(common attributes) in one place
public abstract class BaseModel
{
    //Audit Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
   // private String Name;
   // private String Description;
    private Date createdAt; // You can also use Long for storing time in the form of epoch
    private Date updatedAt;
    private Boolean isDeleted;


}

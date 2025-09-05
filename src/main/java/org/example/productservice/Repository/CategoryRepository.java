package org.example.productservice.Repository;

import org.example.productservice.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>
{
    //JPA Method - JPA implements this on our behalf
    Category findByName(String name);

}

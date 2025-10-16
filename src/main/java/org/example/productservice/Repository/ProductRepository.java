package org.example.productservice.Repository;

import org.example.productservice.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>
{
    /*This is a declared query where Hibernate changes the query to the one needed
    It would get converted to select * from products where id = id
     */
    /*Optional<Object> is just to avoid null pointer exception

     */
      Optional<Product> findById(Long ID);

      Optional<Product> findByTitle(String title);

    //Select * from products where title LIKE '%iphone%' LIMIT 10
    // This is case-sensitive by default
      List<Product> findByTitleContainsFirst10(String title);

      List<Product> findByTitleContainsIgnoreCase(String title);
}

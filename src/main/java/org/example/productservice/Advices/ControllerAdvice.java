package org.example.productservice.Advices;

import org.example.productservice.DTOs.ProductNotFoundErrorDTO;
import org.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice
{
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundErrorDTO> ProductNotFoundExceptionHandler(ProductNotFoundException productNotFoundException)
    {
        // Code to handle the exception and beauty the response
        // We'll create a DTO for it because that's what we'll send the client
        ProductNotFoundErrorDTO productNotFoundErrorDTO = new ProductNotFoundErrorDTO(productNotFoundException.getMessage());

        ResponseEntity<ProductNotFoundErrorDTO> responseEntity = new ResponseEntity<>(productNotFoundErrorDTO, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}

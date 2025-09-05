package org.example.productservice.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ProductNotFoundErrorDTO
{
    private String message;
}

package org.example.productservice.exceptions;

/*
Exception Types:

1. CompileTime Exception/ CheckedException ---> these need to be handled

2. RunTime Exception/ Unchecked Exception

Throwable is the root class of Errors and Exceptions

 */

public class ProductNotFoundException extends Exception
{
    public  ProductNotFoundException(String message)
    {
        super(message);
    }
}
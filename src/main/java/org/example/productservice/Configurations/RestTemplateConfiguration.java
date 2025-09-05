package org.example.productservice.Configurations;

//We just need to return an object of RestTemplate from this class

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//Spring Beans are spring objects which are to be managed by spring container. It's singleton

@Configuration
public class RestTemplateConfiguration
{
    @Bean
     public RestTemplate createRestTemplate()
     {
         return new RestTemplate();
     }
}

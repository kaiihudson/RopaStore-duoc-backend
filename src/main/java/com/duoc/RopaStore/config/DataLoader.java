package com.duoc.RopaStore.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.duoc.RopaStore.model.Product;
import com.duoc.RopaStore.repository.ProductRepository;

@Configuration 
public class DataLoader {
    
    @Bean
    CommandLineRunner loadData(ProductRepository productRepository) {
        return args -> {
            productRepository.save(new Product("Camiseta", "Ropa", 6990.0));
            productRepository.save(new Product("Pantalón", "Ropa", 9990.0));
            productRepository.save(new Product("Zapatos", "Calzado", 24990.0));
            productRepository.save(new Product("Chaqueta", "Ropa", 34990.0));
            productRepository.save(new Product("Sombrero", "Accesorio", 39990.0));
        };
    }
}

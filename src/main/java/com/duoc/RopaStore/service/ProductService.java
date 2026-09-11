package com.duoc.RopaStore.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.duoc.RopaStore.model.Product;
import com.duoc.RopaStore.model.ProductDTO;
import com.duoc.RopaStore.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Public method to consume  the internal repository in order to acquire each and all of the current products available in the repository
     * @return List of products, with a filter to hide internal app id's
     */
    public List<ProductDTO> findAll() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        if (products.isEmpty()) {
            return  productDTOS;
        }
        for (Product product : products) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setName(product.getName());
            productDTO.setType(product.getType());
            productDTO.setPrice(product.getPrice());
            productDTOS.add(productDTO);
        }
        return productDTOS;
    }

    public List<ProductDTO> getSortedByPriceAscending() {
        List<ProductDTO> products = findAll();
        products.sort(Comparator.comparingDouble(ProductDTO::getPrice));
        return products;
    }
}

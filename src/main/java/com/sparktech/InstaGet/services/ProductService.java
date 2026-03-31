package com.sparktech.InstaGet.services;

import com.sparktech.InstaGet.Repository.ProductRepository;
import com.sparktech.InstaGet.Models.Product;
import com.sparktech.InstaGet.dtos.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public List<ProductDto> findAll() {
        return repo.findAll().stream()
                .map(ProductDto::fromProduct)
                .collect(Collectors.toList());
    }

    public Optional<ProductDto> findById(int id) {
        return repo.findById(id).map(ProductDto::fromProduct);
    }

    public ProductDto save(ProductDto dto) {
        Product saved = repo.save(dto.toProduct());
        return ProductDto.fromProduct(saved);
    }

    public ProductDto update(int id, ProductDto dto) {
        Product existing = repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        existing.setName(dto.getName());
        existing.setPrice(dto.getPrice());
        return ProductDto.fromProduct(repo.save(existing));
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}

package com.sparktech.InstaGet.product.controller;

import com.sparktech.InstaGet.product.dto.ProductDto;
import com.sparktech.InstaGet.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDto> getAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getById(@PathVariable int id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto create(@RequestBody ProductDto dto) {
        return productService.save(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable int id, @RequestBody ProductDto dto) {
        return ResponseEntity.ok(productService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

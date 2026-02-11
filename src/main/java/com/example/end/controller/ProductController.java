package com.example.end.controller;

import com.example.end.controller.dto.ProductRequest;
import com.example.end.model.Category;
import com.example.end.model.Product;
import com.example.end.patterns.builder.ProductBuilder;
import com.example.end.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductRequest request) {
        Product product = new ProductBuilder()
                .type(request.getType())
                .name(request.getName())
                .price(request.getPrice())
                .category(new Category(request.getCategoryId(), null))
                .build();
        Product saved = productService.add(product);
        return ResponseEntity.created(URI.create("/api/products/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ProductRequest request) {
        Product product = new ProductBuilder()
                .id(id)
                .type(request.getType())
                .name(request.getName())
                .price(request.getPrice())
                .category(new Category(request.getCategoryId(), null))
                .build();
        productService.update(product);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
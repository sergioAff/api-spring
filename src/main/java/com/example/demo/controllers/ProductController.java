package com.example.demo.controllers;

import com.example.demo.models.ProductoModel;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {this.productService = productService;}

  @PostMapping
  public ResponseEntity<String> addProduct(@RequestBody ProductoModel product) {
    productService.addProduct(product);
    return ResponseEntity.ok("Product added");
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductoModel> getProduct(@PathVariable Long id) {
    return productService.getProduct(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @GetMapping
  public ResponseEntity<List<ProductoModel>> getProducts() {
    return ResponseEntity.ok(productService.getProducts());
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateProduct(@RequestBody ProductoModel product, @PathVariable Long id) {
    try {
      ProductoModel newProduct=productService.updateProduct(product, id);
      return ResponseEntity.ok("Product updated");
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    try {
      productService.deleteProduct(id);
      return ResponseEntity.noContent().build();
    } catch (Exception e) {
      return ResponseEntity.notFound().build();
    }
  }
}
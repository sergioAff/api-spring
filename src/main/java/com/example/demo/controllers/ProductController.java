package com.example.demo.controllers;

import com.example.demo.models.ProductoModel;
import com.example.demo.services.ProductService;
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

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping
  public ResponseEntity<String> addProduct(@RequestBody ProductoModel product) {
    productService.addProduct(product);
    return ResponseEntity.ok("Product added");
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductoModel> getProduct(@PathVariable Integer id) {
    ProductoModel product = productService.getProduct(id);
    if (product == null) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(productService.getProduct(id));
  }

  @GetMapping
  public ResponseEntity<List<ProductoModel>> getProducts() {
    return ResponseEntity.ok(productService.getProducts());
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateProduct(@RequestBody ProductoModel product, @PathVariable Integer id) {
    ProductoModel productId = productService.getProduct(id);
    if (productId == null) {
      return ResponseEntity.notFound().build();
    }
    productService.updateProduct(product, id);
    return ResponseEntity.ok("Product updated");
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
    ProductoModel productId = productService.getProduct(id);
    if (productId == null) {
      return ResponseEntity.notFound().build();
    }
    productService.deleteProduct(id);
    return ResponseEntity.ok("Product deleted");
  }
}
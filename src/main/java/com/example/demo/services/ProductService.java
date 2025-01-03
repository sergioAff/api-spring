package com.example.demo.services;

import com.example.demo.models.ProductoModel;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void addProduct(ProductoModel product) {
    try {
      productRepository.save(product);
    } catch (Exception e) {
      throw new RuntimeException("Product not added:" + e);
    }
  }

  public Optional<ProductoModel> getProduct(Long id) {
    return productRepository.findById(id);
  }

  public List<ProductoModel> getProducts() {
    return productRepository.findAll();
  }

  public ProductoModel updateProduct(ProductoModel product, Long id) {
    return productRepository.findById(id).map(iteration ->{
      iteration.setName(product.getName());
      iteration.setCategory(product.getCategory());
      iteration.setAmmount(product.getAmmount());
      return productRepository.save(iteration);
    }).orElseThrow(() -> new RuntimeException("Product not found"));
  }

  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }
}
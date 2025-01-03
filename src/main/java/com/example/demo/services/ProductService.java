package com.example.demo.services;

import com.example.demo.models.ProductoModel;
import com.example.demo.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
  private final ProductRepository productRepository;

  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public void addProduct(ProductoModel product) {
    productRepository.addProduct(product);
  }

  public ProductoModel getProduct(Integer id) {
    return productRepository.getProduct(id);
  }

  public List<ProductoModel> getProducts() {
    return productRepository.getProducts();
  }

  public void updateProduct(ProductoModel product, Integer id) {
    productRepository.updateProduct(product, id);
  }

  public void deleteProduct(Integer id) {
    productRepository.deleteProduct(id);
  }
}
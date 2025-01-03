package com.example.demo.repositories;

import com.example.demo.models.ProductoModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

  private final Map<Integer, ProductoModel> products = new HashMap<>();

  public void addProduct(ProductoModel product) {
    products.put(product.getId(), product);
  }

  public ProductoModel getProduct(Integer id) {
    return products.get(id);
  }

  public List<ProductoModel> getProducts() {
    return new ArrayList<>(products.values());
  }

  public void updateProduct(ProductoModel product, Integer id) {
    ProductoModel productId = products.get(id);
    if (productId != null) {
      ProductoModel newProduct = new ProductoModel(id, product.getName(), product.getCategory(), product.getAmmount());
      products.put(id, newProduct);
    }
  }

  public void deleteProduct(Integer id) {
    products.remove(id);
  }
}
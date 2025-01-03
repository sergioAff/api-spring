package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductoModel {
  private Integer id;
  private String name;
  private String category;
  private Integer ammount;
  
  public ProductoModel() {
  }
  
  public ProductoModel(Integer id, String name, String category, Integer ammount) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.ammount = ammount;
  }
}

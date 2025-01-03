package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProductoModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String category;
  private Integer ammount;
  
  public ProductoModel() {
  }
  
  public ProductoModel(Long id, String name, String category, Integer ammount) {
    this.id = id;
    this.name = name;
    this.category = category;
    this.ammount = ammount;
  }
}

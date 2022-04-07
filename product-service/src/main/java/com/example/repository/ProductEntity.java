package com.example.repository;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductEntity {
    @Id
    private int id;
    private String name;
    private double price;
}

package com.example.demo.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
public class Product {
    @Id
    private Integer product_id;

    private String color;
    private String size; // или int, смотря, какая размерная сетка( цифры или s,m и тд)
    private String description;
    private Integer price;
    private Integer pieces_in_stock; // количество в наличии

    @ManyToOne
    private Model model;

}
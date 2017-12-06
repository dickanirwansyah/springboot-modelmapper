package com.dicka.restfull.javaserverapi.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "product",
        catalog = "dbproduction")
public class Product implements Serializable{

    @Id
    @Column(name = "idproduct")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idproduct;

    @Column(name = "nama", nullable = false)
    String nama;

    @Column(name = "jumlah", nullable = false)
    int jumlah;

    @Column(name = "price", nullable = false)
    BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "idkategori", nullable = false)
    Kategori kategori;
}

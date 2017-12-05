package com.dicka.restfull.javaserverapi.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@Entity
@Table(name = "kategori",
        catalog = "dbproduction")
public class Kategori implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idkategori")
    int idkategori;

    @Column(name = "nama", nullable = false)
    String nama;

    @Column(name = "deskripsi", nullable = false)
    String deskripsi;

}

package com.dicka.restfull.javaserverapi.mapper;

import com.dicka.restfull.javaserverapi.model.Kategori;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductionUpdateMapper {

    @NotNull
    private int idproduct;

    @NotNull
    private String nama;

    @NotNull
    private int jumlah;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Kategori kategori;
}

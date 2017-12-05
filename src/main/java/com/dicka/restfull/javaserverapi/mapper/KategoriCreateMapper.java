package com.dicka.restfull.javaserverapi.mapper;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class KategoriCreateMapper {

    @NotNull
    private String nama;

    @NotNull
    private String deskripsi;

}

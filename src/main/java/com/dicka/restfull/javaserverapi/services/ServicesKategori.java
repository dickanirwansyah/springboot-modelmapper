package com.dicka.restfull.javaserverapi.services;

import com.dicka.restfull.javaserverapi.model.Kategori;

import java.util.List;

public interface ServicesKategori {

    List<Kategori> getKategoris();

    Kategori getKategori(int idkategori);

    void insertKategori(Kategori kategori);

    Kategori updateKategori(Kategori kategori);

    void deleteKategori(Kategori kategori);

    boolean ifKategoriIsExist(String nama);

}

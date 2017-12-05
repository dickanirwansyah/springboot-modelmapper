package com.dicka.restfull.javaserverapi.dao;

import com.dicka.restfull.javaserverapi.model.Kategori;

import java.util.List;

public interface KategoriDAO {

    List<Kategori> getKategoris();

    Kategori getKategori(int idkategori);

    boolean insertKategori(Kategori kategori);

    void updateKategori(Kategori kategori);

    void deleteKategori(Kategori kategori);

}

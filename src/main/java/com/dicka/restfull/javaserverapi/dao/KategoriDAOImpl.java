package com.dicka.restfull.javaserverapi.dao;

import com.dicka.restfull.javaserverapi.model.Kategori;
import com.dicka.restfull.javaserverapi.services.ServicesKategori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategoriDAOImpl implements KategoriDAO{

    private ServicesKategori servicesKategori;

    @Autowired
    public KategoriDAOImpl(ServicesKategori servicesKategori){
        this.servicesKategori = servicesKategori;
    }

    @Override
    public List<Kategori> getKategoris() {
        return servicesKategori.getKategoris();
    }

    @Override
    public Kategori getKategori(int idkategori) {
        return servicesKategori.getKategori(idkategori);
    }

    @Override
    public boolean insertKategori(Kategori kategori) {
        if(servicesKategori.ifKategoriIsExist(kategori.getNama())){
            System.out.print("nama sudah ada conflict !");
            return false;
        }else{
            servicesKategori.insertKategori(kategori);
            return true;
        }

    }

    @Override
    public void updateKategori(Kategori kategori) {
        servicesKategori.updateKategori(kategori);
    }

    @Override
    public void deleteKategori(Kategori kategori) {
        servicesKategori.deleteKategori(kategori);
    }
}

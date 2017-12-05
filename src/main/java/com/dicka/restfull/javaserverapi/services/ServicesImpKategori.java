package com.dicka.restfull.javaserverapi.services;

import com.dicka.restfull.javaserverapi.model.Kategori;
import com.dicka.restfull.javaserverapi.repository.RepositoryKategori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ServicesImpKategori implements ServicesKategori{

    @PersistenceContext
    private EntityManager entityManager;

    private RepositoryKategori repositoryKategori;

    @Autowired
    public ServicesImpKategori(RepositoryKategori repositoryKategori){
        this.repositoryKategori=repositoryKategori;
    }

    @Override
    public List<Kategori> getKategoris() {
        String hql = "FROM Kategori";
        return entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Kategori getKategori(int idkategori) {
        String hql = "from Kategori as kat where kat.idkategori = ?";
        return (Kategori) entityManager.createQuery(hql)
                .setParameter(1, idkategori).getSingleResult();
    }

    @Override
    public void insertKategori(Kategori kategori) {
        entityManager.persist(kategori);
    }

    @Override
    public Kategori updateKategori(Kategori kategori) {
        if(!entityManager.contains(kategori))
            kategori = entityManager.merge(kategori);
        return kategori;
    }

    @Override
    public void deleteKategori(Kategori kategori) {
        entityManager.remove(kategori);
    }

    @Override
    public boolean ifKategoriIsExist(String nama) {
        String hql = "from Kategori as kat where kat.nama = ?";
        int counted = entityManager.createQuery(hql).setParameter(1, nama)
                .getResultList().size();
        return counted  > 0 ? true: false;
    }
}

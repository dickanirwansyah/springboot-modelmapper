package com.dicka.restfull.javaserverapi.repository;

import com.dicka.restfull.javaserverapi.mapper.KategoriUpdateMapper;
import com.dicka.restfull.javaserverapi.model.Kategori;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RepositoryKategori extends JpaRepository<Kategori, Integer>{

}

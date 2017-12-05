package com.dicka.restfull.javaserverapi.controller;

import com.dicka.restfull.javaserverapi.dao.KategoriDAO;
import com.dicka.restfull.javaserverapi.mapper.KategoriCreateMapper;
import com.dicka.restfull.javaserverapi.mapper.KategoriUpdateMapper;
import com.dicka.restfull.javaserverapi.model.Kategori;
import com.dicka.restfull.javaserverapi.repository.RepositoryKategori;
import com.dicka.restfull.javaserverapi.utilities.DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ControllerKategori {

    @Autowired
    private KategoriDAO kategoriDAO;

    @Autowired
    private RepositoryKategori repositoryKategori;

    @GetMapping(value = "/kategoris")
    public ResponseEntity<List<Kategori>>ListKategori(){
        List<Kategori> kategoriList = kategoriDAO.getKategoris();
        if(kategoriList.isEmpty()){
            return new ResponseEntity<List<Kategori>>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<Kategori>>(kategoriList, HttpStatus.OK);
    }

    @PostMapping(value = "/insertKategori")
    public ResponseEntity<String> insertKategori(@DTO(KategoriCreateMapper.class)Kategori kategori){
        boolean valid = kategoriDAO.insertKategori(kategori);
        if(valid == false){
            return new ResponseEntity<String>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/updateKategori")
    public ResponseEntity<String> updateKategori(@DTO(KategoriUpdateMapper.class)Kategori kategori){
        kategoriDAO.updateKategori(kategori);
        return new ResponseEntity<String>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/deleteKategori/{idkategori}")
    public ResponseEntity<String> deleteKategori(@PathVariable String idkategori){
        Kategori kategori = kategoriDAO.getKategori(Integer.valueOf(idkategori));
        if(kategori == null){
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        }
        kategoriDAO.deleteKategori(kategori);
        return new ResponseEntity<String>(HttpStatus.ACCEPTED);
    }
}

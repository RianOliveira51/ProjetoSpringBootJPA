package com.example.portaChamados.resource;

import com.example.portaChamados.entities.Technicians;
import com.example.portaChamados.entities.User;
import com.example.portaChamados.repositories.TechniciansRepository;
import com.example.portaChamados.service.TecnicianService;
import com.example.portaChamados.service.UserService;
import com.example.portaChamados.service.exceptions.ResourceNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/technicians")
public class TechniciansRouserce {

    @Autowired
    private TecnicianService tecnicianService;

    //EndPoints - pesquisar todos os usuarios
    @GetMapping
    public ResponseEntity<List<Technicians>> findAll() {
        List<Technicians> list = tecnicianService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //EndPoints - pesquisar um usuario especifico por Id
    @GetMapping("/{id}")
    public ResponseEntity<Technicians> findById(@PathVariable Integer id) {
        Technicians technician = tecnicianService.findById(id);
        return ResponseEntity.ok().body(technician);
    }
    //Implementado methodo para autenticação de login
    @PostMapping(value = "/{login}")
    public ResponseEntity<Technicians> findbyId(@RequestBody Technicians th) {
        Technicians obj = tecnicianService.loadUserBylogin(th.getLogin(), th.getPassword());
        return ResponseEntity.ok().body(obj);
    }

    //Endpoints - Criação de tecnicos
    @PutMapping
    public ResponseEntity<Technicians> insert(@RequestBody Technicians th) {
        Technicians obj = tecnicianService.insert(th);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    //Endpoints - Deletar tecnico por id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Technicians> delete(@PathVariable Integer id) {
        tecnicianService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Endpoints - Atualizar tecnico por id
    @PutMapping(value = "/{id}")
    public ResponseEntity<Technicians> update(@PathVariable Integer id,@RequestBody Technicians th) {
        th = tecnicianService.update(id, th);
        return ResponseEntity.ok().body(th);
    }
}

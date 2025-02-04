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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/technicians")
public class TechniciansRouserce {

    @Autowired
    private TecnicianService tecnicianService;

    @GetMapping
    public ResponseEntity<List<Technicians>> findAll() {
        List<Technicians> list = tecnicianService.findAll();
        return ResponseEntity.ok().body(list);
    }

    //Implementado methodo para autenticação de login
    @PostMapping(value = "/{login}")
    public ResponseEntity<Technicians> findbyId(@RequestBody Technicians th) {
        Technicians obj = tecnicianService.loadUserBylogin(th.getLogin(), th.getPassword());
        return ResponseEntity.ok().body(obj);
    }

}

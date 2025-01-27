package com.example.portaChamados.resource;

import com.example.portaChamados.entities.Technicians;
import com.example.portaChamados.repositories.TechniciansRepository;
import com.example.portaChamados.service.TecnicianService;
import com.example.portaChamados.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
}

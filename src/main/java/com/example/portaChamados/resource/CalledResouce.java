package com.example.portaChamados.resource;

import com.example.portaChamados.entities.Called;
import com.example.portaChamados.entities.DTO.AddTechniciansToCalledDto;
import com.example.portaChamados.entities.Technicians;
import com.example.portaChamados.entities.enums.CalledStatus;
import com.example.portaChamados.repositories.CalledRepository;
import com.example.portaChamados.service.CalledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "{calleds}")
public class CalledResouce {

    @Autowired
    private CalledService calledService;

    @GetMapping
    public ResponseEntity<List<Called>> findAll() {
        List<Called> list = calledService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<Called> findById(@PathVariable Integer id) {
        Called called = calledService.findById(id);
        return ResponseEntity.ok().body(called);
    }

    @PutMapping
    public ResponseEntity<Called> Insert(@RequestBody Called called) {
        Called obj = calledService.insert(called);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Called> Delete(@PathVariable Integer id) {
        calledService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Called> update(@PathVariable Integer id, @RequestBody Called called) {
        called =  calledService.update(id, called);
        return ResponseEntity.ok().body(called);
    }

    //Atribuindo usuario.
    @PutMapping(value="/add")
    public ResponseEntity<AddTechniciansToCalledDto> add(@RequestBody AddTechniciansToCalledDto dtorequest) {
        calledService.addTecnicians(dtorequest);
        return ResponseEntity.ok().body(dtorequest);
    }

    //EndPoints listar chamados por Status
    @GetMapping(value = "/status/{status}")
    public ResponseEntity<List<Called>> findStatus(@PathVariable Integer status) {
        List<Called> list = calledService.findStatus(status);
        return ResponseEntity.ok().body(list);
    }
}

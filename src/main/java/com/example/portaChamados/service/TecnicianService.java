package com.example.portaChamados.service;

import com.example.portaChamados.entities.Technicians;
import com.example.portaChamados.repositories.TechniciansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.util.List;

@Service
public class TecnicianService {

   @Autowired
    private TechniciansRepository techniciansRepository;

   public List<Technicians> findAll() {
       return techniciansRepository.findAll();
   }

}

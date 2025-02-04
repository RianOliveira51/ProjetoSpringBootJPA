package com.example.portaChamados.repositories;

import com.example.portaChamados.entities.Technicians;
import com.example.portaChamados.service.exceptions.ResourceNotFoundExeption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TechniciansRepository extends JpaRepository<Technicians, Integer> {

   Technicians findByLoginAndPassword(String login, String password);
}

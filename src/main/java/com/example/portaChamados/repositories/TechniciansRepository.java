package com.example.portaChamados.repositories;

import com.example.portaChamados.entities.Technicians;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechniciansRepository extends JpaRepository<Technicians, Integer> {
}

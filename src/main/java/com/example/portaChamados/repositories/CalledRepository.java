package com.example.portaChamados.repositories;

import com.example.portaChamados.entities.Called;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface CalledRepository extends JpaRepository<Called, Integer> {
}

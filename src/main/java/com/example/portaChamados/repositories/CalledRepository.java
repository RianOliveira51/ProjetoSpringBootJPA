package com.example.portaChamados.repositories;

import com.example.portaChamados.entities.Called;
import com.example.portaChamados.entities.Technicians;
import com.example.portaChamados.entities.enums.CalledStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public interface CalledRepository extends JpaRepository<Called, Integer> {

    List<Called> findByStatus(Integer status);
}

package com.example.portaChamados.repositories;

import com.example.portaChamados.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

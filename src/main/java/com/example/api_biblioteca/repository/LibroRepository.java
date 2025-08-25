package com.example.api_biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.api_biblioteca.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}


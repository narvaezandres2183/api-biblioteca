package com.example.api_biblioteca.service;

import com.example.api_biblioteca.model.Libro;
import com.example.api_biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    // para obtener todos
    public List<Libro> obtenerTodos() {
        return libroRepository.findAll();
    }

    // para obtener por id
    public Optional<Libro> obtenerPorId(Long id) {
        return libroRepository.findById(id);
    }

    // para guardar nuevo
    public Libro guardar(Libro libro) {
        return libroRepository.save(libro);
    }

    // para actualizar existente por id
    public Optional<Libro> actualizar(Long id, Libro cambios) {
        return libroRepository.findById(id).map(actual -> {
            actual.setTitulo(cambios.getTitulo());
            actual.setAutor(cambios.getAutor());
            actual.setGenero(cambios.getGenero());
            actual.setAnioPublicacion(cambios.getAnioPublicacion());
            return libroRepository.save(actual);
        });
    }

    // para eliminar por id
    public void eliminar(Long id) {
        libroRepository.deleteById(id);
    }
}


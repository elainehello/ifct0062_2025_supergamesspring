package com.fernandopaniagua.ifct0062_2025_supergamesspring.service;

import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Genre;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.repository.IGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService implements IGenreService {
    @Autowired
    IGenreRepository genreRepository;

    @Override
    public Genre findById(Integer id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }
}

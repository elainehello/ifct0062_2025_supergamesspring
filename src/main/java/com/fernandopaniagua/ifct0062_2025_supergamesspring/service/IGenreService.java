package com.fernandopaniagua.ifct0062_2025_supergamesspring.service;

import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Genre;

import java.util.List;

public interface IGenreService {
    public List<Genre> getAllGenres();
    public Genre findById(Integer id);
}

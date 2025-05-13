package com.fernandopaniagua.ifct0062_2025_supergamesspring.repository;

import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenreRepository extends JpaRepository<Genre, Integer> {
}

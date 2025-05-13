package com.fernandopaniagua.ifct0062_2025_supergamesspring.repository;

import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVideogameRepository extends JpaRepository<Videogame, Integer> {
}

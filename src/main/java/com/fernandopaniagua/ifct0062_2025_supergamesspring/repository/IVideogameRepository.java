package com.fernandopaniagua.ifct0062_2025_supergamesspring.repository;

import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Videogame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IVideogameRepository extends JpaRepository<Videogame, Integer> {
    @Query("SELECT DISTINCT vg.platform FROM Videogame vg")
    List<String> getPlatformNames();

    List<Videogame> findByPlatform(String platform);
}

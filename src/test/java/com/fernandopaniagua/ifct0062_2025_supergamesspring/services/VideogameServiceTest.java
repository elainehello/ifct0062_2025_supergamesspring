package com.fernandopaniagua.ifct0062_2025_supergamesspring.services;

import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Genre;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Videogame;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.repository.IGenreRepository;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.repository.IVideogameRepository;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.service.VideogameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class VideogameServiceTest {
    @Autowired
    VideogameService videogameService;

    @Autowired
    IGenreRepository genreRepository;

    @Autowired
    IVideogameRepository videogameRepository;

    @Test
    public void createVideogame() {
        Genre genero = new Genre("Genero borrar", "Descripción borrar");
        genero = this.genreRepository.save(genero);
        Videogame vg1 = new Videogame("Borrar", "Plataforma", true, 100, genero);
        vg1 = this.videogameService.createVideogame(vg1);
        assertNotNull(vg1);
        this.videogameRepository.delete(vg1);
        this.genreRepository.delete(genero);
    }
}

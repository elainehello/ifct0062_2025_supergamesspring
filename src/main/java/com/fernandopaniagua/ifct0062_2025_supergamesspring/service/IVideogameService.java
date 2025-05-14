package com.fernandopaniagua.ifct0062_2025_supergamesspring.service;

import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Videogame;

import java.util.List;

public interface IVideogameService {

    public List<Videogame> getAllVideogames();
    public Videogame createVideogame(Videogame videogame);
    public Videogame findVideogameById(Integer id);
    public List<Videogame> findVideogameByPlatform(String platform);
    public List<String> getAllPlatforms();
    public void deleteVideogame(Integer videogame);
    public List<String> findAllPlatformNames();
}

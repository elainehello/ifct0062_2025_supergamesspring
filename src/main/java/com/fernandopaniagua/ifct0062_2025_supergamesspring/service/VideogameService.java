package com.fernandopaniagua.ifct0062_2025_supergamesspring.service;

import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Videogame;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.repository.IVideogameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideogameService implements IVideogameService {
    @Autowired
    IVideogameRepository videogameRepository;

    @Override
    public List<Videogame> getAllVideogames(){
        return videogameRepository.findAll();
    }

    @Override
    public Videogame createVideogame(Videogame videogame) {
        return videogameRepository.save(videogame);
    }

    @Override
    public Videogame findVideogameById(Integer id) {
        return videogameRepository.findById(id).orElse(null);
    }

    @Override
    public List<Videogame> findVideogameByPlatform(String platform) {
        return videogameRepository.findByPlatform(platform);
    }

    @Override
    public List<String> getAllPlatforms() {
        return videogameRepository.getPlatformNames();
    }

    @Override
    public void deleteVideogame(Integer videogame) {
        videogameRepository.deleteById(videogame);
    }

    @Override
    public List<String> findAllPlatformNames() {
        return videogameRepository.getPlatformNames();
    }
}

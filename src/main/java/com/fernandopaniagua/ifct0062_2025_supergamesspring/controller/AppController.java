package com.fernandopaniagua.ifct0062_2025_supergamesspring.controller;

import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Genre;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Videogame;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.service.GenreService;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AppController {
    VideogameService videogameService;
    GenreService genreService;
    public AppController(VideogameService videogameService, GenreService genreService) {
        this.videogameService = videogameService;
        this.genreService = genreService;
    }

    @GetMapping("/")
    public String showMain(Model model){
        List<Videogame> videogameList = this.videogameService.getAllVideogames();
        model.addAttribute("videogames", videogameList);
        return "index";
    }

    @GetMapping("/delete-videogame")
    public String deleteVideogame(@RequestParam Integer id){
        System.err.println("Borrando videogame con id: " + id);
        return "redirect:/";
    }

    @GetMapping("/create-videogame")
    public String initCreateVideogame(Model model){
        List<Genre> genreList = this.genreService.getAllGenres();
        model.addAttribute("genres",genreList);
        return "create_videogame";
    }

    @PostMapping("/videogames")
    public String createVideogame(@ModelAttribute Videogame newVideogame) {
        this.videogameService.createVideogame(newVideogame);
        return "redirect:/";
    }
}

package com.fernandopaniagua.ifct0062_2025_supergamesspring.controller;

import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Genre;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Videogame;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.service.GenreService;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        this.videogameService.deleteVideogame(id);
        return "redirect:/";
    }

    @GetMapping("/edit-videogame")
    public ModelAndView editVideogame(@RequestParam Integer id) {
        ModelAndView mav = new ModelAndView("edit_videogame");
        List<Genre> genreList = this.genreService.getAllGenres();
        Videogame videogame = this.videogameService.findVideogameById(id);
        mav.addObject("genres", genreList);
        mav.addObject("videogame", videogame);
        return mav;
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

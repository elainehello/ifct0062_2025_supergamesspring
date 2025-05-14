package com.fernandopaniagua.ifct0062_2025_supergamesspring.controller;

import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Genre;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.model.Videogame;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.service.GenreService;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.service.IGenreService;
import com.fernandopaniagua.ifct0062_2025_supergamesspring.service.VideogameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {
    VideogameService videogameService;
    IGenreService genreService;
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

    @GetMapping("/search-videogame")
    public String searchVideogame(@RequestParam String title, Model model) {
        List<Videogame> videogameList = this.videogameService.findVideogameByPlatform(title);
        List<String> platforms = this.videogameService.findAllPlatformNames();

        model.addAttribute("videogames", videogameList);
        model.addAttribute("platforms", platforms);
        model.addAttribute("searchTerm", title);

        return "buscar_videogame";  // Match exactly with the template name
    }

    @PostMapping("/videogames")
    public String createVideogame(@ModelAttribute Videogame newVideogame) {
        this.videogameService.createVideogame(newVideogame);
        return "redirect:/";
    }

    // Update an existing videogame
    @PostMapping("/update-videogame")
    public String updateVideogame(@RequestParam("id") Integer id,
                                  @RequestParam("title") String title,
                                  @RequestParam("platform") String platform,
                                  @RequestParam("multiplayer") boolean multiplayer,
                                  @RequestParam("price") int price,
                                  @RequestParam("genre.id") Integer genreId) {

        // Get the existing videogame
        Videogame videogame = videogameService.findVideogameById(id);
        Genre genre = genreService.findById(genreId);

        // Update the fields
        videogame.setTitle(title);
        videogame.setPlatform(platform);
        videogame.setMultiplayer(multiplayer);
        videogame.setPrice(price);
        videogame.setGenre(genre);

        // Use createVideogame which internally uses save()
        videogameService.createVideogame(videogame);

        return "redirect:/";
    }

    @GetMapping("/find-videogame")
    public String searchVideogame(Model model){
        List<String> platformNames = videogameService.getAllPlatforms();
        model.addAttribute("platform_names", platformNames);
        return "search-page";
    }

}

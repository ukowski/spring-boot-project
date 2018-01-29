package com.codecool.filmsmanager.film;

import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;


@RestController
@RequestMapping(path = "/films")
public class FilmController {

    private FilmServiceImpl filmService;

    public FilmController(FilmServiceImpl filmService) {
        this.filmService = filmService;
    }

    @GetMapping(path = "")
    public Iterable<Film> index() {
        return filmService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Film show(@PathVariable Integer id) {
        return filmService.findById(id);
    }

    @PostMapping(path = "")
    public void create(@RequestBody Film film) {
        filmService.create(film);
    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable Integer id, @RequestBody Film film) {
        filmService.update(id, film);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id){
        filmService.delete(id);
    }
}

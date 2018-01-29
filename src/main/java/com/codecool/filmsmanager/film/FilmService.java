package com.codecool.filmsmanager.film;

public interface FilmService {

    void create(Film film);
    Iterable<Film> findAll();
    Film findById(Integer id);
    void update(Integer id, Film film);
    void delete(Integer id);
}

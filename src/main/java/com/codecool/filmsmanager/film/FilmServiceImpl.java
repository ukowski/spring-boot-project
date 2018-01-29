package com.codecool.filmsmanager.film;

import com.codecool.filmsmanager.category.Category;
import com.codecool.filmsmanager.category.CategoryService;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;

@Service
public class FilmServiceImpl implements FilmService {

    private FilmRepository filmRepository;
    private CategoryService categoryService;

    public FilmServiceImpl(FilmRepository filmRepository, CategoryService categoryService) {
        this.filmRepository = filmRepository;
        this.categoryService = categoryService;
    }

    public void create(Film film) {
        Category category = categoryService.findByName(film.getCategory().getName());
        if(category != null){
            film.setCategory(category);
        }
        filmRepository.save(film);
    }

    public Iterable<Film> findAll(){
        return filmRepository.findAll();
    }

    public Film findById(Integer id) {
        return filmRepository.findOne(id);
    }

    public void delete(Integer id) {
        filmRepository.delete(id);
    }

    public void update(Integer id, Film film) throws IllegalArgumentException{

        film.setId(id);

        for(Field field : film.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                if (field.get(film) == null) {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        Category category = categoryService.findByName(film.getCategory().getName());
        if(category != null){
            film.setCategory(category);
        } else {
            categoryService.create(film.getCategory());
            Category newCategory = categoryService.findByName(film.getCategory().getName());
            film.setCategory(newCategory);
        }

        filmRepository.save(film);
    }
}

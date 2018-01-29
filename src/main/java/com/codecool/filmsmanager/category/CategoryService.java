package com.codecool.filmsmanager.category;

public interface CategoryService {

    void create(Category category);
    Iterable<Category> findAll();
    Category findById(Integer id);
    Category findByName(String name);
    void update(Integer id, Category category);
    void delete(Integer id);
}

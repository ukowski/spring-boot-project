package com.codecool.filmsmanager.category;

import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void create(Category category) {
        categoryRepository.save(category);
    }

    public Iterable<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Integer id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    public void delete(Integer id) {
        categoryRepository.delete(id);
    }

    public void update(Integer id, Category category) {
        category.setId(id);
        categoryRepository.save(category);
    }
}

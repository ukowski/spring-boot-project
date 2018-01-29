package com.codecool.filmsmanager.category;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "")
    public Iterable<Category> index(){
        return categoryService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Category show(@PathVariable Integer id) {
        return categoryService.findById(id);
    }

    @PostMapping(path = "")
    public void create(@RequestBody Category category){
        categoryService.create(category);
    }

    @PutMapping(path = "/{id}")
    public void update(@PathVariable Integer id, @RequestBody Category category){
        categoryService.update(id, category);
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable Integer id) {
        categoryService.delete(id);
    }
}

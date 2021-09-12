package kz.aa.baza.controllers;

import kz.aa.baza.dtos.InputCategory;
import kz.aa.baza.models.Category;
import kz.aa.baza.models.CategoryGroup;
import kz.aa.baza.services.CategoryGroupService;
import kz.aa.baza.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryGroupService categoryGroupService;

    @Autowired
    public CategoryController(CategoryService categoryService,
                              CategoryGroupService categoryGroupService) {
        this.categoryService = categoryService;
        this.categoryGroupService = categoryGroupService;
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody InputCategory inputCategory) {
        final Category category = categoryService.create(inputCategory);
        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<List<CategoryGroup>> getAll(@RequestParam(required = false) Long parent,
                                                      @RequestParam(required = false) String name) {
        final List<CategoryGroup> categoryGroups = categoryGroupService.getAll(parent, name);
        return ResponseEntity.ok(categoryGroups);
    }
}

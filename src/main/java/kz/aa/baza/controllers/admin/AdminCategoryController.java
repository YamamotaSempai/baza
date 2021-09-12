package kz.aa.baza.controllers.admin;

import kz.aa.baza.dtos.InputCategoryGroup;
import kz.aa.baza.models.CategoryGroup;
import kz.aa.baza.services.CategoryGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/categories")
public class AdminCategoryController {
    private final CategoryGroupService categoryGroupService;

    @Autowired
    public AdminCategoryController(CategoryGroupService categoryGroupService) {
        this.categoryGroupService = categoryGroupService;
    }

    @PostMapping
    public ResponseEntity<CategoryGroup> create(@RequestBody InputCategoryGroup inputCategoryGroup) {
        final CategoryGroup categoryGroup = categoryGroupService.create(inputCategoryGroup);
        return ResponseEntity.ok(categoryGroup);
    }

    @PutMapping
    public ResponseEntity<CategoryGroup> edit(@RequestBody InputCategoryGroup inputCategoryGroup) {
        final CategoryGroup categoryGroup = categoryGroupService.update(inputCategoryGroup);
        return ResponseEntity.ok(categoryGroup);
    }

    @GetMapping
    public ResponseEntity<List<CategoryGroup>> getAll(@RequestParam(required = false) Long parent,
                                                      @RequestParam(required = false) String name) {
        return ResponseEntity.ok(categoryGroupService.getAll(parent, name));
    }

}

package kz.aa.baza.services.impl;

import kz.aa.baza.dtos.InputCategory;
import kz.aa.baza.dtos.InputCategoryGroup;
import kz.aa.baza.exceptions.CategoryGroupException;
import kz.aa.baza.models.Category;
import kz.aa.baza.models.CategoryGroup;
import kz.aa.baza.repositories.CategoryGroupRepository;
import kz.aa.baza.services.CategoryGroupService;
import kz.aa.baza.services.CategoryService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryGroupServiceImpl implements CategoryGroupService {
    private final CategoryService categoryService;
    private final CategoryGroupRepository categoryGroupRepository;

    @Autowired
    public CategoryGroupServiceImpl(CategoryService categoryService,
                                    CategoryGroupRepository categoryGroupRepository) {
        this.categoryService = categoryService;
        this.categoryGroupRepository = categoryGroupRepository;
    }

    @Override
    public @NonNull List<CategoryGroup> getAll(Long parent, String name) { // TODO: 12.09.2021 fix
        return categoryGroupRepository.findAll();
    }

    @Override
    public @NonNull CategoryGroup create(@NonNull InputCategoryGroup inputCategoryGroup) {
        final Category category = categoryService.create(new InputCategory(inputCategoryGroup.getName()));
        final Long parentId = inputCategoryGroup.getParent();
        CategoryGroup categoryGroup = new CategoryGroup();
        categoryGroup.setCategory(category);
        if (parentId != null) {
            final Category parent = categoryService.get(parentId);
            throwIfObjectIsNull(parent);
            categoryGroup.setParent(parent);
        }
        return categoryGroupRepository.save(categoryGroup);
    }

    @Override
    public @NonNull CategoryGroup update(@NonNull InputCategoryGroup inputCategoryGroup) {
        final CategoryGroup categoryGroup = categoryGroupRepository.findById(inputCategoryGroup.getId())
                .orElseThrow(CategoryGroupException::new);
        final Category category = categoryService.get(inputCategoryGroup.getCategoryId());
        throwIfObjectIsNull(category);
        final Category parent = categoryService.get(inputCategoryGroup.getParent());
        throwIfObjectIsNull(parent);
        return categoryGroupRepository.save(categoryGroup);
    }

    private void throwIfObjectIsNull(Object object) {
        if (object == null) {
            throw new CategoryGroupException();
        }
    }
}

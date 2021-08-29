package kz.aa.baza.services.impl;

import kz.aa.baza.models.CategoryGroup;
import kz.aa.baza.repositories.CategoryGroupRepository;
import kz.aa.baza.services.CategoryGroupService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryGroupServiceImpl implements CategoryGroupService {
    private final CategoryGroupRepository categoryGroupRepository;

    @Autowired
    public CategoryGroupServiceImpl(CategoryGroupRepository categoryGroupRepository) {
        this.categoryGroupRepository = categoryGroupRepository;
    }

    @Override
    public @NonNull List<CategoryGroup> getAll() {
        return categoryGroupRepository.findAll();
    }
}

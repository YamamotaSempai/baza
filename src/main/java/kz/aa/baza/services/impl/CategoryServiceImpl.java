package kz.aa.baza.services.impl;

import kz.aa.baza.dtos.InputCategory;
import kz.aa.baza.models.Category;
import kz.aa.baza.repositories.CategoryRepository;
import kz.aa.baza.services.CategoryService;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(ModelMapper modelMapper,
                               CategoryRepository categoryRepository) {
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public @NonNull Category create(@NonNull InputCategory inputCategory) {
        final Category category = modelMapper.map(inputCategory, Category.class);
        return categoryRepository.save(category);
    }
}

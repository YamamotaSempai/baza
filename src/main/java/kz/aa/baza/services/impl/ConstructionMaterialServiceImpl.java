package kz.aa.baza.services.impl;

import kz.aa.baza.dtos.InputConstructionMaterialDto;
import kz.aa.baza.exceptions.CityException;
import kz.aa.baza.exceptions.ConstructorMaterialException;
import kz.aa.baza.models.Category;
import kz.aa.baza.models.ConstructionMaterial;
import kz.aa.baza.repositories.ConstructionMaterialRepository;
import kz.aa.baza.services.CategoryService;
import kz.aa.baza.services.CityService;
import kz.aa.baza.services.ConstructionMaterialService;
import kz.as.registry.City;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConstructionMaterialServiceImpl implements ConstructionMaterialService {
    private final CityService cityService;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final ConstructionMaterialRepository constructionMaterialRepository;

    @Autowired
    public ConstructionMaterialServiceImpl(CityService cityService,
                                           ModelMapper modelMapper,
                                           CategoryService categoryService,
                                           ConstructionMaterialRepository constructionMaterialRepository) {
        this.cityService = cityService;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.constructionMaterialRepository = constructionMaterialRepository;
    }

    @Override
    public @NonNull Page<ConstructionMaterial> getAll(@NonNull Pageable pageable) {
        return constructionMaterialRepository.findAll(pageable);
    }

    @Override
    public ConstructionMaterial get(@NonNull Long id) {
        final Optional<ConstructionMaterial> optionalConstructionMaterial = constructionMaterialRepository.findById(id);
        final boolean isPresent = optionalConstructionMaterial.isPresent();
        return isPresent ? optionalConstructionMaterial.get() : null;
    }

    @Override
    public @NonNull ConstructionMaterial create(@NonNull InputConstructionMaterialDto inputConstructionMaterialDto) {
        throwIfTitleAlreadyExists(inputConstructionMaterialDto.getTitle());
        throwIfCityNotExists(inputConstructionMaterialDto.getCityId());
        final ConstructionMaterial constructionMaterial = modelMapper.map(inputConstructionMaterialDto, ConstructionMaterial.class);
        return constructionMaterialRepository.save(constructionMaterial);
    }

    @Override
    public @NonNull ConstructionMaterial update(@NonNull InputConstructionMaterialDto inputConstructionMaterialDto) {
        final ConstructionMaterial constructionMaterial = get(inputConstructionMaterialDto.getId());
        throwIfObjectIsNull(constructionMaterial);
        final Long categoryId = inputConstructionMaterialDto.getCategoryId();
        final Category category = categoryId == null ? null : categoryService.get(categoryId);
        constructionMaterial.setUpdatedBy(inputConstructionMaterialDto.getAuthor());
        constructionMaterial.setAddress(inputConstructionMaterialDto.getAddress() == null ? constructionMaterial.getAddress() : inputConstructionMaterialDto.getAddress());
        constructionMaterial.setCategory(category == null ? constructionMaterial.getCategory() : category);
        constructionMaterial.setCityId(inputConstructionMaterialDto.getCityId() == null ? constructionMaterial.getCityId() : inputConstructionMaterialDto.getCityId());
        constructionMaterial.setDescription(inputConstructionMaterialDto.getDescription() == null ? constructionMaterial.getDescription() : inputConstructionMaterialDto.getDescription());
        constructionMaterial.setPrice(inputConstructionMaterialDto.getPrice() == 0 ? constructionMaterial.getPrice() : inputConstructionMaterialDto.getPrice());
        constructionMaterial.setTitle(inputConstructionMaterialDto.getTitle() == null ? constructionMaterial.getTitle() : inputConstructionMaterialDto.getTitle());
        return constructionMaterialRepository.save(constructionMaterial);
    }

    private void throwIfObjectIsNull(Object object) {
        if (object == null) {
            throw new ConstructorMaterialException();
        }
    }

    private void throwIfCityNotExists(Long cityId) {
        final City city = cityService.getById(cityId);
        if (city == null) {
            throw new CityException();
        }
    }

    private void throwIfTitleAlreadyExists(String title) {
        final ConstructionMaterial foundObject = constructionMaterialRepository.findByTitle(title);
        if (foundObject != null) {
            throw new ConstructorMaterialException();
        }
    }

}

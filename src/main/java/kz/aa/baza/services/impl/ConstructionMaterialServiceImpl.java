package kz.aa.baza.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.aa.baza.dtos.InputConstructionMaterialDto;
import kz.aa.baza.exceptions.ConstructorMaterialException;
import kz.aa.baza.models.City;
import kz.aa.baza.models.ConstructionMaterial;
import kz.aa.baza.repositories.ConstructionMaterialRepository;
import kz.aa.baza.services.ConstructionMaterialService;
import lombok.NonNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConstructionMaterialServiceImpl implements ConstructionMaterialService {

    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;
    private final ConstructionMaterialRepository constructionMaterialRepository;

    @Autowired
    public ConstructionMaterialServiceImpl(                                           ModelMapper modelMapper,
                                           ObjectMapper objectMapper,
                                           ConstructionMaterialRepository constructionMaterialRepository) {
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
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
    public @NonNull ConstructionMaterial create(@NonNull InputConstructionMaterialDto constructionMaterialDto) {
        final ConstructionMaterial constructionMaterial = modelMapper.map(constructionMaterialDto, ConstructionMaterial.class);
        throwIfTitleAlreadyExists(constructionMaterial.getTitle());
        throwIfCityNotExists(constructionMaterial.getCity());
        return null;
    }

    private void throwIfCityNotExists(City city) {

    }

    private void throwIfTitleAlreadyExists(String title) {
        final ConstructionMaterial foundObject = constructionMaterialRepository.findByTitle(title);
        if (foundObject != null) {
            throw new ConstructorMaterialException();
        }
    }

}

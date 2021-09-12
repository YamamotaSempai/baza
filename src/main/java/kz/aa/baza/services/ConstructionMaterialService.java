package kz.aa.baza.services;

import kz.aa.baza.dtos.InputConstructionMaterialDto;
import kz.aa.baza.models.ConstructionMaterial;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConstructionMaterialService {
    @NonNull Page<ConstructionMaterial> getAll(@NonNull Pageable pageable);

    ConstructionMaterial get(@NonNull Long id);

    @NonNull ConstructionMaterial create(@NonNull InputConstructionMaterialDto constructionMaterialDto);

    @NonNull ConstructionMaterial update(@NonNull InputConstructionMaterialDto constructionMaterialDto);
}

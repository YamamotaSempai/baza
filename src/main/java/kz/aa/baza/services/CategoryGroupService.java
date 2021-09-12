package kz.aa.baza.services;

import kz.aa.baza.dtos.InputCategoryGroup;
import kz.aa.baza.models.CategoryGroup;
import lombok.NonNull;

import java.util.List;

public interface CategoryGroupService {
    @NonNull List<CategoryGroup> getAll(Long parent, String name);

    @NonNull CategoryGroup create(@NonNull InputCategoryGroup inputCategoryGroup);

    @NonNull CategoryGroup update(@NonNull InputCategoryGroup inputCategoryGroup);
}

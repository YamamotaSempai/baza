package kz.aa.baza.services;

import kz.aa.baza.dtos.InputCategory;
import kz.aa.baza.models.Category;
import lombok.NonNull;

public interface CategoryService {
    @NonNull Category create(@NonNull InputCategory inputCategory);
}

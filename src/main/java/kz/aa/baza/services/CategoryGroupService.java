package kz.aa.baza.services;

import kz.aa.baza.models.CategoryGroup;
import lombok.NonNull;

import java.util.List;

public interface CategoryGroupService {
    @NonNull List<CategoryGroup> getAll();
}

package kz.aa.baza.services;

import kz.as.registry.City;
import lombok.NonNull;

public interface CityService {
    City getById(@NonNull Long id);
}

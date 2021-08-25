package kz.aa.baza.repositories;

import kz.aa.baza.models.ConstructionMaterial;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructionMaterialRepository extends JpaRepository<ConstructionMaterial, Long> {
    ConstructionMaterial findByTitle(@NonNull String title);
}

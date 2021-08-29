package kz.aa.baza.repositories;

import kz.aa.baza.models.CategoryGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryGroupRepository extends JpaRepository<CategoryGroup, Long> {
}

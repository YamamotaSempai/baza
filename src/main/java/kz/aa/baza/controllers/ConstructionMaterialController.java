package kz.aa.baza.controllers;

import kz.aa.baza.dtos.InputConstructionMaterialDto;
import kz.aa.baza.models.ConstructionMaterial;
import kz.aa.baza.services.ConstructionMaterialService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/construction-materials")
public class ConstructionMaterialController {
    private final ConstructionMaterialService constructionMaterialService;

    @Autowired
    public ConstructionMaterialController(ConstructionMaterialService constructionMaterialService) {
        this.constructionMaterialService = constructionMaterialService;
    }

    @GetMapping
    public ResponseEntity<Page<ConstructionMaterial>> getAll(@NonNull Pageable pageable) {
        final Page<ConstructionMaterial> constructionMaterialPage = constructionMaterialService.getAll(pageable);
        return ResponseEntity.ok(constructionMaterialPage);
    }

    @PostMapping
    public ResponseEntity<ConstructionMaterial> create(@RequestBody InputConstructionMaterialDto constructionMaterialDto,
                                                       Authentication authentication) {
        constructionMaterialDto.setAuthor(1L);
        ConstructionMaterial constructionMaterial = constructionMaterialService.create(constructionMaterialDto);
        return ResponseEntity.ok(constructionMaterial);
    }

}

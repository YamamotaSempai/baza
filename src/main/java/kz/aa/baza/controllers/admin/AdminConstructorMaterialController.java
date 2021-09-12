package kz.aa.baza.controllers.admin;

import kz.aa.baza.dtos.InputConstructionMaterialDto;
import kz.aa.baza.models.ConstructionMaterial;
import kz.aa.baza.services.ConstructionMaterialService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/admin/construction-materials")
public class AdminConstructorMaterialController {
    private final ConstructionMaterialService constructionMaterialService;

    @Autowired
    public AdminConstructorMaterialController(ConstructionMaterialService constructionMaterialService) {
        this.constructionMaterialService = constructionMaterialService;
    }

    @GetMapping
    public ResponseEntity<Page<ConstructionMaterial>> getAll(@NonNull Pageable pageable) {
        final Page<ConstructionMaterial> constructionMaterialPage = constructionMaterialService.getAll(pageable);
        return ResponseEntity.ok(constructionMaterialPage);
    }

    @PostMapping
    public ResponseEntity<ConstructionMaterial> create(@RequestBody InputConstructionMaterialDto constructionMaterialDto,
                                                       Principal principal) {
        constructionMaterialDto.setAuthor(Long.valueOf(principal.getName()));
        ConstructionMaterial constructionMaterial = constructionMaterialService.create(constructionMaterialDto);
        return ResponseEntity.ok(constructionMaterial);
    }

    @PutMapping
    public ResponseEntity<ConstructionMaterial> edit(@RequestBody InputConstructionMaterialDto constructionMaterialDto,
                                                       Principal principal) {
        constructionMaterialDto.setAuthor(Long.valueOf(principal.getName()));
        ConstructionMaterial constructionMaterial = constructionMaterialService.update(constructionMaterialDto);
        return ResponseEntity.ok(constructionMaterial);
    }
}

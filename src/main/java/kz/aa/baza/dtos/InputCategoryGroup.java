package kz.aa.baza.dtos;

import lombok.Data;

@Data
public class InputCategoryGroup {
    private Long id;
    private String name;
    private Long parent;
    private Long categoryId;
}

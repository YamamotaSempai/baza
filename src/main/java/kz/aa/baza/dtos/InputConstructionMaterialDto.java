package kz.aa.baza.dtos;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class InputConstructionMaterialDto implements Serializable {
    private Long id;
    private Long author;
    private double price;
    private Long categoryId;
    private @NotNull String title;
    private @NotNull String description;
    private @NotNull Long cityId;
    private @NotNull String address;

    public InputConstructionMaterialDto() {
    }
}

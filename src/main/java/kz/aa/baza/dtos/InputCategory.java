package kz.aa.baza.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class InputCategory implements Serializable {
    private String name;

    public InputCategory() {
    }

    public InputCategory(String name) {
        this.name = name;
    }
}

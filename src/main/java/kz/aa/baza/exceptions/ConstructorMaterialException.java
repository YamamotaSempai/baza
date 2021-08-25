package kz.aa.baza.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ConstructorMaterialException extends RuntimeException{
    public ConstructorMaterialException() {
    }

    public ConstructorMaterialException(String message) {
        super(message);
    }
}

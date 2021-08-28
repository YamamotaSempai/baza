package kz.aa.baza.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CityException extends RuntimeException {
    public CityException() {
    }

    public CityException(String message) {
        super(message);
    }
}

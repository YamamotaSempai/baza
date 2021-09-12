package kz.aa.baza.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CategoryGroupException extends RuntimeException{
    public CategoryGroupException() {
    }

    public CategoryGroupException(String message) {
        super(message);
    }
}

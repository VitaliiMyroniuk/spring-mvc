package ua.company.myroniuk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Vitalii Myroniuk
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "File name is not valid")
public class BadFileNameException extends RuntimeException {
    public BadFileNameException() {
    }

    public BadFileNameException(String message) {
        super(message);
    }
}

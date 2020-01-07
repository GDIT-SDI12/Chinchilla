package nz.students.forsdi.chinchilla.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
    // 1) An exception handler for UserNotFoundException
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(EntityNotFoundException exc) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        // 2) create ErrorResponse
        ErrorResponse error = new ErrorResponse(
                status.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        // 3) return ResponseEntity
        return new ResponseEntity<>(error, status);
    }

    // Another exception handler, to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exc) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponse error = new ErrorResponse(
                status.value(),
                exc.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(error, status);
    }
}

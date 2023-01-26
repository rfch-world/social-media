package world.rfch.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;

@RestControllerAdvice
public class NotFoundExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleUserNotFoundException(UserNotFoundException e) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDTO, notFound);
    }

    @ExceptionHandler(SocialMediaNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleSocialMediaNotFoundException(SocialMediaNotFoundException e) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDTO, notFound);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handlePostNotFoundException(PostNotFoundException e) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDTO, notFound);
    }

    @ExceptionHandler(MessageNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleMessageNotFoundException(MessageNotFoundException e) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDTO, notFound);
    }

    @ExceptionHandler(CommentNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleCommentNotFoundException(CommentNotFoundException e) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(errorResponseDTO, notFound);
    }


}

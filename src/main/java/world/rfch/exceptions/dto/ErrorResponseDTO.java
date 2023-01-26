package world.rfch.exceptions.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ErrorResponseDTO {

    final String message;
    final HttpStatus httpStatus;
    final ZonedDateTime dateTime;


    public ErrorResponseDTO(String message, HttpStatus httpStatus, ZonedDateTime dateTime) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.dateTime = dateTime;

    }


}

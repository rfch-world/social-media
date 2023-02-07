package world.rfch.dto.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Builder
@Data
public class ResponseDto {
    private  String data;
    private HttpStatus httpStatus;
}

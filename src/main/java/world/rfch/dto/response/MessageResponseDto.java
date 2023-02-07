package world.rfch.dto.response;

import com.sun.istack.NotNull;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageResponseDto {

    @NotNull
    private String senderUsername;

    @NotNull
    private String receiverUsername;

    @NotBlank
    private String content;

    @NotNull
    private Date date;

}

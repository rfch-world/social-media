package world.rfch.dto.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequestDTO {

    @NotNull
    private Long senderUserId;

    @NotNull
    private Long receiverUserId;

    @NotBlank
    private String content;

    @NotNull
    private Date date;

}

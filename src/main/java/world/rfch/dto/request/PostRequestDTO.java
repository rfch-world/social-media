package world.rfch.dto.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import world.rfch.enums.PostStatus;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDTO {

    @NotNull
    private Long userId;

    @NotBlank(message = "Please fill the all field")
    private String content;

    private Date date;

    @NotBlank
    private String source;

    @NotNull
    private PostStatus status;

    List<UserRequestDTO> taggedUserList;

}

package world.rfch.dto.response;
import com.sun.istack.NotNull;
import lombok.*;
import world.rfch.enums.PostStatus;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {

    @NotNull
    private String username;

    @NotBlank(message = "Please fill the all field")
    private String content;

    private Date date;

    @NotBlank
    private String source;

    @NotNull
    private PostStatus status;

    List<String> taggedUserIdList;



}

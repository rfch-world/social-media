package world.rfch.dto.request;

import lombok.*;
import world.rfch.jpa.entity.CommentEntity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Builder
@Data
@RequiredArgsConstructor
public class CommentRequestDTO {

    @NotBlank
    private String content;

    @NotNull
    private Long userId;

    @NotNull
    private Long postId;

    @NotNull
    private Date date;

    /*public CommentEntity toEntity(){
        return CommentEntity.builder()
                .content(this.content)
                .userId(this.name)
                .surname(this.surname)
                .email(this.email)
                .password(this.password)
                .build();
    }*/
}

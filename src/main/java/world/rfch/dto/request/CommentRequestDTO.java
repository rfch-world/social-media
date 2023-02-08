package world.rfch.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import world.rfch.jpa.entity.CommentEntity;
import world.rfch.service.PostService;
import world.rfch.service.UserService;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
public class CommentRequestDTO {

    private final UserService userService;
    private final PostService postService;

    @NotBlank
    private String content;

    @NotNull
    private Long userId;

    @NotNull
    private Long postId;

    @NotNull
    private Date date;

    public CommentEntity toEntity() {
        return CommentEntity.builder().content(this.content).user(userService.findById(this.userId)).post(postService.findById(this.postId)).date(this.date).build();
    }
}

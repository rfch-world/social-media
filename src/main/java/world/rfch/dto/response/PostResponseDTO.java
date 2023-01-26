package world.rfch.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import world.rfch.enums.PostStatus;
import world.rfch.jpa.entity.CommentEntity;
import world.rfch.jpa.entity.UserEntity;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDTO {

    private Long userId;

    private String content;

    private Date date;

    private String source;

    private PostStatus status;

    private Integer commentCount;

    private Integer likeCount;

    private List<UserResponseDTO> taggedUserList;

    private List<UserResponseDTO> likedUserList;

    private List<CommentResponseDTO> commentList;


}

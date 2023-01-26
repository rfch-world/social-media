package world.rfch.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDTO {

    private String content;

    private Integer likeCount;

    private Long userId;

    private Long postId;

    private Date date;

    private List<UserResponseDTO> likedUserList;

    private Long repliedCommentId;

    private List<CommentResponseDTO> replyListOfComment;


}

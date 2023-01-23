package world.rfch.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comment")
public class CommentEntity extends BaseEntity {

    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @Column(name = "date")
    private Date date;

    @ManyToMany(mappedBy = "likedCommentList")
    private List<UserEntity> likedUserList;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private CommentEntity repliedComment;

    @OneToMany(mappedBy = "repliedComment")
    private List<CommentEntity> replyListOfComment;

}

package world.rfch.jpa.entity;

import lombok.*;
import world.rfch.enums.PostStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "post")
public class PostEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
    private Date date;

    @Column(name = "source")
    private String source;

    @Enumerated(EnumType.STRING)
    @Column(name = "post_status")
    private PostStatus status;

    @Column(name = "comment_count")
    private Integer commentCount;

    @Column(name = "like_count")
    private Integer likeCount;

    @ManyToMany(mappedBy = "postListThatUserIsTaggedIn")
    private List<UserEntity> taggedUserList;

    @ManyToMany(mappedBy = "likedPostList")
    private List<UserEntity> likedUserList;

    @OneToMany(mappedBy = "post")
    private List<CommentEntity> commentList;
}

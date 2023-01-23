package world.rfch.entity;

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
@Table(name = "post")
public class Post extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String content;
    private Date date;
    private String image;
    private String video;
    private PostStatus;

    @OneToMany
    @JoinTable(
            name = "post_tag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tagged_user_id"))
    private List<Post> postTag;

    @OneToMany
    @JoinTable(
            name = "post_like",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "liked_post_id"))
    private List<Post> postLike;
}

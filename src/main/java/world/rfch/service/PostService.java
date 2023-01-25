package world.rfch.service;

import javafx.geometry.Pos;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import world.rfch.enums.PostStatus;
import world.rfch.jpa.entity.PostEntity;

import java.util.List;
@Service
public interface PostService {

    List<PostEntity> findAllByOrderByLikeCountDescDate();
    List<PostEntity> findAllByStatusOrderByLikeCountDescDate(PostStatus postStatus);
    void removeLike(Long userId,  Long postId);
    int isLiked(Long userId, Long postId);
    void addLike( Long userId,  Long postId);
    void save(PostEntity post);
    void findByPostById(Long postId);
    void deletePost(PostEntity post);
     List<PostEntity> getAllPosts();
}

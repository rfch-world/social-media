package world.rfch.service;

import javafx.geometry.Pos;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import world.rfch.enums.PostStatus;
import world.rfch.jpa.entity.PostEntity;

import java.util.List;
public interface PostService {
    List<PostEntity> findAllByOrderByLikeCountDescDate();

    List<PostEntity> findAllByStatusOrderByLikeCountDescDate(PostStatus postStatus);

    void deleteLike(Long userId,  Long postId);

    int isLiked(Long userId, Long postId);

    void addLike( Long userId,  Long postId);

    PostEntity save(PostEntity post);

    PostEntity findById(Long postId);

    void deleteById(Long id);

     List<PostEntity> findAll();
}

package world.rfch.service;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import world.rfch.jpa.entity.CommentEntity;
import world.rfch.jpa.entity.PostEntity;

import java.util.List;

@Service
public interface CommentService {
    List<CommentEntity> findAllByPostOrderByLikeCount(PostEntity post);

    void deleteLike( Long userId,Long commentId);

    int isLiked( Long userId,  Long commentId);

    void addLike(Long userId,Long commentId);

    CommentEntity save(CommentEntity commentEntity);

    void deleteById(Long id);

    CommentEntity findById(Long commentId);
}

package world.rfch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import world.rfch.jpa.entity.CommentEntity;
import world.rfch.jpa.entity.PostEntity;
import world.rfch.jpa.repository.CommentRepository;
import world.rfch.service.CommentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
private final CommentRepository commentRepository;

    @Override
    public List<CommentEntity> findAllByPostOrderByLikeCount(PostEntity post) {
        return commentRepository.findAllByPostOrderByLikeCount(post);
    }

    @Override
    public void deleteLike(Long userId, Long commentId) {
            commentRepository.deleteLike(userId,commentId);
    }

    @Override
    public int isLiked(Long userId, Long commentId) {
        return commentRepository.isLiked(userId, commentId);
    }

    @Override
    public void addLike(Long userId, Long commentId) {
   commentRepository.isLiked(userId, commentId);
    }

    @Override
    public void save(CommentEntity commentEntity) {
       commentRepository.save(commentEntity);
    }

    @Override
    public void deleteById(Long id) {
commentRepository.deleteById(id);
    }


    @Override
    public CommentEntity getCommentByCommentId(Long commentId) {
     CommentEntity commentEntity=commentRepository.findById(commentId).orElseThrow(()->new RuntimeException(
             "can not find comment with given commentid"));
     return commentEntity;
    }

}

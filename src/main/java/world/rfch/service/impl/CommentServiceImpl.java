package world.rfch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import world.rfch.exceptions.notfound.CommentNotFoundException;
import world.rfch.jpa.entity.CommentEntity;
import world.rfch.jpa.entity.PostEntity;
import world.rfch.jpa.repository.CommentRepository;
import world.rfch.service.CommentService;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
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
    public CommentEntity save(CommentEntity commentEntity) {
       return commentRepository.save(commentEntity);
    }

    @Override
    public void deleteById(Long id) {
commentRepository.deleteById(id);
    }


    @Override
    public CommentEntity findById(Long commentId) {
     return commentRepository.findById(commentId).
             orElseThrow(()->new CommentNotFoundException("Can't find comment with given id"));
    }

}

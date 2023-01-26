package world.rfch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import world.rfch.enums.PostStatus;
import world.rfch.jpa.entity.PostEntity;
import world.rfch.jpa.repository.PostRepository;
import world.rfch.service.PostService;

import java.util.List;

@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public List<PostEntity> findAllByOrderByLikeCountDescDate() {
        return postRepository.findAllByOrderByLikeCountDescDateAsc();
    }

    @Override
    public List<PostEntity> findAllByStatusOrderByLikeCountDescDate(PostStatus postStatus) {
        return postRepository.findAllByStatusOrderByLikeCountDescDateAsc(postStatus);
    }

    @Override
    public void deleteLike(Long userId, Long postId) {
postRepository.deleteLike(userId, postId);
    }

    @Override
    public int isLiked(Long userId, Long postId) {
        return postRepository.isLiked(userId, postId);
    }

    @Override
    public void addLike(Long userId, Long postId) {
postRepository.addLike(userId, postId);
    }

    @Override
    public PostEntity save(PostEntity post) {
        return postRepository.save(post);
    }

    @Override
    public PostEntity findById(Long postId) {
        return postRepository.findById(postId).
                orElseThrow(()-> new RuntimeException("Can not find post with given by id"));
    }

    @Override
    public void deleteById(Long id) {
postRepository.deleteById(id);
    }

    @Override
    public List<PostEntity> findAll() {
        return postRepository.findAll();
    }

}

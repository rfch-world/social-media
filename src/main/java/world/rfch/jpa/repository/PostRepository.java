package world.rfch.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import world.rfch.jpa.entity.PostEntity;
import world.rfch.enums.PostStatus;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {

    List<PostEntity> findAllByOrderByLikeCountDescDateAsc();

    List<PostEntity> findAllByStatusOrderByLikeCountDescDateAsc(PostStatus postStatus);

    @Query(value="DELETE FROM post_like WHERE user_id = :userId AND post_id =:postId>",
            nativeQuery = true)
    boolean deleteLike(@Param("userId") Long userId, @Param("postId") Long postId);

    @Query(value="SELECT EXISTS (SELECT 1 FROM post_like WHERE user_id=:userId AND liked_post_id =:postId)",
            nativeQuery = true)
    boolean isLiked(@Param("userId") Long userId, @Param("postId") Long postId);

    @Query(value="INSERT INTO post_like(user_id,post_id) values(:userId,:postId)",nativeQuery = true)
    boolean addLike(@Param("userId") Long userId, @Param("postId") Long postId);



}

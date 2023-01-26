package world.rfch.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import world.rfch.jpa.entity.CommentEntity;
import world.rfch.jpa.entity.PostEntity;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<CommentEntity,Long> {

    List<CommentEntity> findAllByPostOrderByLikeCount(PostEntity post);

    @Modifying
    @Query(value="DELETE FROM comment_like WHERE user_id = :userId AND comment_id =:commentId",
            nativeQuery = true)
    void deleteLike(@Param("userId") Long userId, @Param("commentId") Long commentId);

    @Query(value="SELECT EXISTS (SELECT * FROM comment_like WHERE user_id=:userId AND comment_id =:commentId)",
            nativeQuery = true)
    int isLiked(@Param("userId") Long userId, @Param("commentId") Long commentId);

    @Modifying
    @Query(value="INSERT INTO comment_like(user_id,comment_id) values(:userId,:commentId)",nativeQuery = true)
    void addLike(@Param("userId") Long userId, @Param("commentId") Long commentId);

}

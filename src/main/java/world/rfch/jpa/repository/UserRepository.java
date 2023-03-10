package world.rfch.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import world.rfch.jpa.entity.UserEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    List<UserEntity> findUserByNameAndSurname(String name, String surname);
    List<UserEntity> findUserByName(String name);
    List<UserEntity> findUserBySurname(String name);
    List<UserEntity> findUserByNameOrSurname(String name, String surname);
    Optional<UserEntity> findUserByEmail(String email);
    Optional<UserEntity> findUserByUsername(String username);
    @Query(value="SELECT EXISTS (SELECT 1 FROM friendship) WHERE user_id=:userId AND friend_id =:friendId)",
            nativeQuery = true)
    int isFriend(Long userId,Long friendId);

}

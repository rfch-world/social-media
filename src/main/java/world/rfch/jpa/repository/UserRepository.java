package world.rfch.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import world.rfch.jpa.entity.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findUserByNameAndSurname(String name, String surname);
    Optional<UserEntity> findUserByName(String name);
    Optional<UserEntity> findUserBySurname(String name);
    Optional<UserEntity> findUserByNameOrSurname(String name, String surname);
    Optional<UserEntity> findUserByEmail(String email);
    Optional<UserEntity> findUserByUsername(String username);
    Optional<UserEntity> findByEmail(String email);
    @Query(value="SELECT EXISTS (SELECT 1 FROM friendship) WHERE user_id=:userId AND friend_id =:friendId)",
            nativeQuery = true)
    int isFriend(Long userId,Long friendId);

}

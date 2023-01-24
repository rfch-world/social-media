package world.rfch.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import world.rfch.jpa.entity.SocialMediaEntity;
import world.rfch.jpa.entity.UserEntity;

import java.util.List;

@Repository
public interface SocialMediaRepository extends JpaRepository<SocialMediaEntity,Long> {

    List<SocialMediaEntity> findAllByUser(UserEntity userEntity);
}

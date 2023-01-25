package world.rfch.service;

import org.springframework.stereotype.Service;
import world.rfch.jpa.entity.SocialMediaEntity;
import world.rfch.jpa.entity.UserEntity;

import java.util.List;

@Service
public interface SocialMediaEntityService {
    List<SocialMediaEntity> findAllByUser(UserEntity userEntity);

    SocialMediaEntity save(SocialMediaEntity socialMediaEntity);

    void  deleteById(Long id);

    SocialMediaEntity findById(Long id);
}

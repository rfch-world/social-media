package world.rfch.service;

import org.springframework.stereotype.Service;
import world.rfch.jpa.entity.SocialMediaEntity;
import world.rfch.jpa.entity.UserEntity;

import java.util.List;

@Service
public interface SocialMediaEntityService {
    List<SocialMediaEntity> findAllByUser(UserEntity userEntity);
    void saveSocialMedia(SocialMediaEntity socialMediaEntity);
    void  deleteSocialMediaById(Long id);
}

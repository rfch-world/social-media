package world.rfch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import world.rfch.jpa.entity.SocialMediaEntity;
import world.rfch.jpa.entity.UserEntity;
import world.rfch.jpa.repository.SocialMediaRepository;
import world.rfch.service.SocialMediaEntityService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SocialMediaServiceImpl implements SocialMediaEntityService {
private final SocialMediaRepository socialMediaRepository;


    @Override
    public List<SocialMediaEntity> findAllByUser(UserEntity userEntity) {
        return socialMediaRepository.findAllByUser(userEntity);
    }

    @Override
    public void saveSocialMedia(SocialMediaEntity socialMediaEntity) {
        socialMediaRepository.save(socialMediaEntity);
    }

    @Override
    public void deleteSocialMediaById(Long id) {
socialMediaRepository.deleteById(id);
    }
}

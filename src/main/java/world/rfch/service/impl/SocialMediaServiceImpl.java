package world.rfch.service.impl;

import lombok.RequiredArgsConstructor;
import world.rfch.jpa.entity.SocialMediaEntity;
import world.rfch.jpa.entity.UserEntity;
import world.rfch.jpa.repository.SocialMediaRepository;
import world.rfch.service.SocialMediaService;

import java.util.List;

@RequiredArgsConstructor
public class SocialMediaServiceImpl implements SocialMediaService {

    private final SocialMediaRepository socialMediaRepository;

    @Override
    public List<SocialMediaEntity> findAllByUser(UserEntity userEntity) {
        return socialMediaRepository.findAllByUser(userEntity);
    }

    @Override
    public SocialMediaEntity save(SocialMediaEntity socialMediaEntity) {
        return socialMediaRepository.save(socialMediaEntity);
    }

    @Override
    public void deleteById(Long id) {
socialMediaRepository.deleteById(id);
    }

    @Override
    public SocialMediaEntity findById(Long id) {
        return socialMediaRepository.findById(id).
                orElseThrow(()->new RuntimeException("can not find social media with given id"));
    }
}

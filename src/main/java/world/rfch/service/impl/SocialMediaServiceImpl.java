package world.rfch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import world.rfch.exceptions.SocialMediaNotFoundException;
import world.rfch.jpa.entity.SocialMediaEntity;
import world.rfch.jpa.entity.UserEntity;
import world.rfch.jpa.repository.SocialMediaRepository;
import world.rfch.service.SocialMediaEntityService;

import java.util.List;

@RequiredArgsConstructor
public class SocialMediaServiceImpl implements SocialMediaEntityService {

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
                orElseThrow(()->new SocialMediaNotFoundException("can not find social media with given id"));
    }
}

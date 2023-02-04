package world.rfch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import world.rfch.jpa.entity.Authority;
import world.rfch.jpa.repository.AuthorityRepository;
import world.rfch.service.AuthService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthorityRepository authorityRepository;

    @Override
    public Authority getByAuthority(String authority) {
        return authorityRepository.findByAuthority(authority);
    }
}

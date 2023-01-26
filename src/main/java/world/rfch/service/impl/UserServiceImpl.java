package world.rfch.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import world.rfch.enums.UserRole;
import world.rfch.exceptions.EmailAlreadyUsedException;
import world.rfch.jpa.entity.Authority;
import world.rfch.jpa.entity.UserEntity;
import world.rfch.jpa.repository.AuthorityRepository;
import world.rfch.jpa.repository.UserRepository;
import world.rfch.service.UserService;
import world.rfch.service.dto.RegistrationDto;

import java.util.HashSet;
import java.util.Set;

import static world.rfch.enums.UserRole.ROLE_USER;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper;
    private final AuthorityRepository authorityRepository;

    @Override
    @Transactional
    public void register(RegistrationDto dto) {
        userRepository.findByEmail(dto.getEmail())
                .ifPresent(user -> {
                    throw new EmailAlreadyUsedException(dto.getEmail());
                });
        UserEntity user = createUserEntity(dto);
        userRepository.save(user);
    }


    private UserEntity createUserEntity(RegistrationDto dto) {
        UserEntity user = mapper.map(dto, UserEntity.class);
        Authority authority = Authority.builder()
                .authority(ROLE_USER.toString())
                .build();
        authorityRepository.save(authority);
        Set<Authority> userAuthority = new HashSet<>();
        userAuthority.add(authority);
        user.setAuthorities(userAuthority);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        return user;
    }
}

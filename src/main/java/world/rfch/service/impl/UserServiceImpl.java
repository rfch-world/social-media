package world.rfch.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import world.rfch.exceptions.EmailAlreadyUsedException;
import world.rfch.jpa.entity.Authority;
import world.rfch.jpa.entity.UserEntity;
import world.rfch.jpa.repository.AuthorityRepository;
import world.rfch.jpa.repository.UserRepository;
import world.rfch.service.UserService;
import world.rfch.dto.RegistrationDto;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static world.rfch.enums.UserRole.ROLE_USER;

@Service
@RequiredArgsConstructor
@Transactional
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

    @Override
    public Optional<UserEntity> findUserByNameAndSurname(String name, String surname) {
        return userRepository.findUserByNameAndSurname(name,surname);
    }

    @Override
    public Optional<UserEntity> findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public Optional<UserEntity> findUserBySurname(String surname) {
        return userRepository.findUserBySurname(surname);
    }

    @Override
    public Optional<UserEntity> findUserByNameOrSurname(String name, String surname) {
        return userRepository.findUserByNameOrSurname(name, surname);
    }

    @Override
    public UserEntity findUserByEmail(String email) {
        return userRepository.findUserByEmail(email)
                .orElseThrow(()->new RuntimeException("Can't find user with given email"));
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(()->new RuntimeException("Can't find user with given username"));
    }

    @Override
    public int isFriend(Long userId, Long friendId) {
        return userRepository.isFriend(userId, friendId);
    }

    @Override
    public UserEntity save(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Can't find user with given id"));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}

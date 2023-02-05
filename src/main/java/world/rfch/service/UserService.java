package world.rfch.service;

import world.rfch.dto.RegistrationDto;
import world.rfch.jpa.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void register(RegistrationDto dto);

    Optional<UserEntity> findUserByNameAndSurname(String name, String surname);

    Optional<UserEntity> findUserByName(String name);

    Optional<UserEntity> findUserBySurname(String surname);

    Optional<UserEntity> findUserByNameOrSurname(String name, String surname);

    UserEntity findUserByEmail(String email);

    UserEntity findUserByUsername(String username);

    int isFriend(Long userId,Long friendId);

    UserEntity save(UserEntity user);

    List<UserEntity> findAll();

    UserEntity findById(Long userId);

    void deleteById(Long id);
}

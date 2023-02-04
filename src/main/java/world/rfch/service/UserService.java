package world.rfch.service;

import world.rfch.dto.RegistrationDto;
import world.rfch.jpa.entity.UserEntity;

import java.util.List;

public interface UserService {
    void register(RegistrationDto dto);

    List<UserEntity> findUserByNameAndSurname(String name, String surname);

    List<UserEntity> findUserByName(String name);

    List<UserEntity> findUserBySurname(String surname);

    List<UserEntity> findUserByNameOrSurname(String name, String surname);

    UserEntity findUserByEmail(String email);

    UserEntity findUserByUsername(String username);

    int isFriend(Long userId,Long friendId);

    UserEntity save(UserEntity user);

    List<UserEntity> findAll();

    UserEntity findById(Long userId);

    void deleteById(Long id);
}

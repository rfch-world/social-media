package world.rfch.service;

import org.springframework.stereotype.Service;
import world.rfch.jpa.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
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


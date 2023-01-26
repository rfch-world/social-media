package world.rfch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import world.rfch.exceptions.UserNotFoundException;
import world.rfch.jpa.entity.UserEntity;
import world.rfch.jpa.repository.UserRepository;
import world.rfch.service.UserService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

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
    public Optional<UserEntity> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public Optional<UserEntity> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
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
        return userRepository.findById(userId).
                orElseThrow(()->new UserNotFoundException("can not find user with given id"));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}

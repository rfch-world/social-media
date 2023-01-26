package world.rfch.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import world.rfch.exceptions.notfound.UserNotFoundException;
import world.rfch.jpa.entity.UserEntity;
import world.rfch.jpa.repository.UserRepository;
import world.rfch.service.UserService;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserEntity> findUserByNameAndSurname(String name, String surname) {
        return userRepository.findUserByNameAndSurname(name,surname);
    }

    @Override
    public List<UserEntity> findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public List<UserEntity> findUserBySurname(String surname) {
        return userRepository.findUserBySurname(surname);
    }

    @Override
    public List<UserEntity> findUserByNameOrSurname(String name, String surname) {
        return userRepository.findUserByNameOrSurname(name, surname);
    }

    @Override
    public UserEntity findUserByEmail(String email) {
        return userRepository.findUserByEmail(email)
                .orElseThrow(()->new UserNotFoundException("Can't find user with given email"));
    }

    @Override
    public UserEntity findUserByUsername(String username) {
        return userRepository.findUserByUsername(username)
                .orElseThrow(()->new UserNotFoundException("Can't find user with given username"));
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
                .orElseThrow(()->new UserNotFoundException("Can't find user with given id"));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}

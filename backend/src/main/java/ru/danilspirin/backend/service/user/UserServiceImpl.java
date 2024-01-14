package ru.danilspirin.backend.service.user;

import org.springframework.stereotype.Service;
import ru.danilspirin.backend.exception.user.UserNotFoundException;
import ru.danilspirin.backend.model.enitiy.UserModel;
import ru.danilspirin.backend.repository.UserRepository;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UserModel> getUserList() {
        return userRepository.findAll();
    }

    @Override
    public UserModel getUser(Long userId) {
        Optional<UserModel> findById = userRepository.findById(userId);

        if (findById.isEmpty()) {
            throw new UserNotFoundException(userId);
        }

        return findById.get();
    }

    @Override
    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }

    @Override
    public UserModel replaceUser(Long userId, UserModel userToReplace) {
        userToReplace.setId(userId);
        return userRepository.save(userToReplace);
    }

    @Override
    public void deleteUser(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
        } else {
            throw new UserNotFoundException(userId);
        }
    }
}
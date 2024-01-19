package ru.danilspirin.backend.service.user;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.danilspirin.backend.exception.user.UserNotFoundException;
import ru.danilspirin.backend.model.User;
import ru.danilspirin.backend.repository.UserRepository;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository repository;

    @Override
    public User getUserById(Long userId) {
        return repository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }
}

package ru.danilspirin.backend.service.user;

import ru.danilspirin.backend.model.enitiy.UserModel;

import java.util.List;

public interface UserService {

    List<UserModel> getUserList();

    UserModel getUser(Long userId);

    UserModel createUser(UserModel user);

    UserModel replaceUser(Long userId, UserModel userToReplace);

    void deleteUser(Long userId);
}
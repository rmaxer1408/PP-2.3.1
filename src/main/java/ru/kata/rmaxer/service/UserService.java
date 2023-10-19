package ru.kata.rmaxer.service;

import ru.kata.rmaxer.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    User getUserById(int id);

    void createUser(User user);

    void updateUser(User user);

    void removeUser(User user);
}

package ru.kata.rmaxer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.rmaxer.dao.UserDAO;
import ru.kata.rmaxer.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Transactional
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Transactional
    public void removeUser(User user) {
        userDAO.removeUser(getUserById(user.getId()));
    }
}

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

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return userDAO.getUsers();
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(int id) {
        return userDAO.getUserById(id);
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        userDAO.removeUser(id);
    }
}

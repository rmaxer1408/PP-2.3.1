package ru.kata.rmaxer.dao;

import org.springframework.stereotype.Repository;
import ru.kata.rmaxer.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    public void createUser(User user) {
        entityManager.persist(user);
    }

    public void updateUser(User user) {
        entityManager.merge(user);
    }

    public void removeUser(User user) {
        entityManager.remove(getUserById(user.getId()));
    }
}

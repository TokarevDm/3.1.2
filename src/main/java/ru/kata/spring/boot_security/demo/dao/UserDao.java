package ru.kata.spring.boot_security.demo.dao;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUser(int id);

    void addUser(User user);

    void deleteUser(User user);

    void editUser(User user);

    User getByName(String username);
}

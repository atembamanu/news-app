package dao;

import models.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);
    List<User> getAllUsers();
    List<User> getUserById(int id);
    void deleteById(int id);
    void deleteAllUsers();
}

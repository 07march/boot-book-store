package by.bookstoreboot.bookstoreboot.service;

import by.bookstoreboot.bookstoreboot.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User delete(User user);

    User update(User user);

    List<User> findAll();

    User findByID(int id);

    User findByLogin(String login);

    List<User> findAllByName(String name);

}

package by.bookstoreboot.bookstoreboot.repository;

import by.bookstoreboot.bookstoreboot.entity.Role;
import by.bookstoreboot.bookstoreboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);
    List<User> findAllByName(String name);

}

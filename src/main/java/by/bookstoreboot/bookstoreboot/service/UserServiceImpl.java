package by.bookstoreboot.bookstoreboot.service;

import by.bookstoreboot.bookstoreboot.entity.Role;
import by.bookstoreboot.bookstoreboot.entity.User;
import by.bookstoreboot.bookstoreboot.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Data
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User delete(User user) {
        userRepository.delete(user);
        return null;
    }

    @Override
    public User update(User user) {
        User use = userRepository.findById(user.getId()).get();
        if (use.getLogin() != null){
            user.setLogin(use.getLogin());
        }
        if (use.getName() != null){
            user.setName(use.getName());
        }
        if (use.getPassword() != null){
            user.setPassword(use.getPassword());
        }
        if (use.getRole() != null){
            user.setRole(use.getRole());
        }
        return userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findByID(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAllByName(String name) {
        return userRepository.findAllByName(name);
    }

}

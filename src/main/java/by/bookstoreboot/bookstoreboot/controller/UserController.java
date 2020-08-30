package by.bookstoreboot.bookstoreboot.controller;

import by.bookstoreboot.bookstoreboot.entity.Key;
import by.bookstoreboot.bookstoreboot.entity.Role;
import by.bookstoreboot.bookstoreboot.entity.User;
import by.bookstoreboot.bookstoreboot.service.KeyService;
import by.bookstoreboot.bookstoreboot.service.UserService;
import by.bookstoreboot.bookstoreboot.service.dto.UserWithApiKeyDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.UUID;

@Data
@RestController
@RequestMapping(path = "/user")
@Validated
public class UserController {

    private final UserService userService;
    private final KeyService keyService;

    @PostMapping(path = "/auth")
    public ResponseEntity<Key> authorization(@RequestParam String login,
                                                           @RequestParam String password) {
        User user = userService.findByLogin(login);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (login.equals("admin")) {
            user.setRole(Role.ADMIN);
        } else {
            user.setRole(Role.USER);
        }

        if (!user.getPassword().equals(password)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        UUID uuid = UUID.randomUUID();
        Key key = new Key(uuid, user.getRole());
        keyService.save(key);
        return new ResponseEntity<>(key, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> registration(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<User> delete(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userService.delete(user), HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<User> update(@Valid @RequestBody User user){
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    @GetMapping(path = "/get/all")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/get/id")
    public ResponseEntity<User> getById(@Min(1) int id) {
        return new ResponseEntity<>(userService.findByID(id), HttpStatus.OK);
    }

    @GetMapping(path = "/get/login")
    public ResponseEntity<User> getByLogin(@RequestParam String login) {
        return new ResponseEntity<>(userService.findByLogin(login), HttpStatus.OK);
    }

    @GetMapping(path = "/get/name")
    public ResponseEntity<List<User>> getAllByName(@RequestParam String name) {
        return new ResponseEntity<>(userService.findAllByName(name), HttpStatus.OK);
    }
}

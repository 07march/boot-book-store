package by.bookstoreboot.bookstoreboot.controller;

import by.bookstoreboot.bookstoreboot.entity.Key;
import by.bookstoreboot.bookstoreboot.entity.Role;
import by.bookstoreboot.bookstoreboot.service.KeyService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Data
@RestController
@RequestMapping(path = "/key")
public class KeyController {

    private KeyService keyService;

    @GetMapping(path = "find/uuid")
    public ResponseEntity<Key> findKeyByUuid(@RequestBody UUID uuid){
        return new ResponseEntity<>(keyService.findKeyByUuid(uuid), HttpStatus.OK);
    }

    @GetMapping(path = "find/role")
    public ResponseEntity<Key> findKeyByUuid(@RequestBody Role role){
        return new ResponseEntity<>(keyService.findKeyByRole(role), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Key> save(@RequestBody Key key){
        return new ResponseEntity<>(keyService.save(key), HttpStatus.CREATED);
    }
}

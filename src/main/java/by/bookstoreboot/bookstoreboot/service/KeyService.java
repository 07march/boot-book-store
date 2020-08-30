package by.bookstoreboot.bookstoreboot.service;


import by.bookstoreboot.bookstoreboot.entity.Key;
import by.bookstoreboot.bookstoreboot.entity.Role;

import java.util.UUID;

public interface KeyService {

    Key findKeyByUuid(UUID uuid);
    Key findKeyByRole(Role role);
    Key save(Key key);
}

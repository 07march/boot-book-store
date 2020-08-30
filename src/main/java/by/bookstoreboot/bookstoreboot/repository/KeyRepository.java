package by.bookstoreboot.bookstoreboot.repository;

import by.bookstoreboot.bookstoreboot.entity.Key;
import by.bookstoreboot.bookstoreboot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KeyRepository extends JpaRepository<Key, Integer> {

    Key findKeyByUuid(UUID uuid);
    Key findKeyByRole(Role role);

}

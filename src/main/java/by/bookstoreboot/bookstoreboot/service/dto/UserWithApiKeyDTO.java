package by.bookstoreboot.bookstoreboot.service.dto;

import by.bookstoreboot.bookstoreboot.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWithApiKeyDTO {
    User user;
    UUID uuid;
}

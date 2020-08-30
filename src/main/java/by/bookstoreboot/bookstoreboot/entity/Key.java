package by.bookstoreboot.bookstoreboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Embeddable
public class Key implements Serializable {

    @Id
    @GeneratedValue
    private int id;
//    @NotBlank(message = "not blank!")
//    @NotNull(message = "role is not null")
//    @NotEmpty(message = "not empty! enter some characters")
    @Enumerated(value = EnumType.STRING)
    private Role role;
//    @NotBlank(message = "not blank!")
//    @NotNull(message = "uuid is not null")
//    @NotEmpty(message = "not empty! enter some characters")
    private UUID uuid;

    public Key(UUID uuid, Role role) {
        this.uuid = uuid;
        this.role = role;
    }

}

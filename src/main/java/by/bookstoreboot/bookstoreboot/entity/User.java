package by.bookstoreboot.bookstoreboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "not blank!")
    @NotNull(message = "Login is not null")
    @NotEmpty(message = "not empty! enter some characters")
    private String login;

    @NotBlank(message = "not blank!")
    @NotNull(message = "name is not null")
    @NotEmpty(message = "not empty! enter some characters")
    private String name;

    @NotBlank(message = "not blank!")
    @NotNull(message = "password is not null")
    @NotEmpty(message = "not empty! enter some characters")
    private String password;

    @NotNull(message = "not null! enter USER or ADMIN")
    private Role role;
}

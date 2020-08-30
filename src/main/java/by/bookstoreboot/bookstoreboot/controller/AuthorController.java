package by.bookstoreboot.bookstoreboot.controller;

import by.bookstoreboot.bookstoreboot.entity.Author;
import by.bookstoreboot.bookstoreboot.service.AuthorService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping(path = "/author")
@Validated
@Data
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> addAuthor(@Valid @RequestBody Author name) {
        return new ResponseEntity<>(authorService.add(name), HttpStatus.CREATED);
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<Author> deleteAuthor(@RequestBody @Valid Author name) {
        return new ResponseEntity<>(authorService.deleteAuthor(name), HttpStatus.OK);
    }

    @PostMapping(path = "/delete/id")
    public ResponseEntity<Author> deleteAuthorById(@Min(1) int id) {
        return new ResponseEntity<>(authorService.deleteAuthorById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<Author> updateAuthor(@RequestBody @Valid Author name) {
        return new ResponseEntity<>(authorService.updateAuthor(name), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all")
    public ResponseEntity<List<Author>> findAll() {
        return new ResponseEntity<>(authorService.findAllAuthors(), HttpStatus.OK);
    }

    @GetMapping(path = "/find/name")
    public ResponseEntity<Author> findAuthorByName(@RequestParam @NotEmpty @NotBlank String name) {
        return new ResponseEntity<>(authorService.findAuthorByName(name), HttpStatus.OK);
    }

    @GetMapping(path = "/find/id")
    public ResponseEntity<Author> findAuthorById(@Min(1) int id) {
        return new ResponseEntity<>(authorService.findAuthorById(id), HttpStatus.OK);
    }
}

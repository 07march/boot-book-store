package by.bookstoreboot.bookstoreboot.controller;

import by.bookstoreboot.bookstoreboot.entity.Author;
import by.bookstoreboot.bookstoreboot.entity.Book;
import by.bookstoreboot.bookstoreboot.entity.Key;
import by.bookstoreboot.bookstoreboot.entity.Role;
import by.bookstoreboot.bookstoreboot.service.BookService;
import by.bookstoreboot.bookstoreboot.service.KeyService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@RestController
@Validated
@RequestMapping(path = "/book")
public class BookController {

    private final BookService bookService;
    private final KeyService keyService;

    @PostMapping
    public ResponseEntity<Book> add(@RequestBody @Valid Book book, @RequestHeader("token") String key) {
        Key keyByUuid = keyService.findKeyByUuid(UUID.fromString(key));
        if (keyByUuid == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (keyByUuid.getRole().equals(Role.ADMIN)) {
            return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping(path = "/delete/book")
    public ResponseEntity<Book> delete(@RequestBody @Valid Book book) {
        return new ResponseEntity<>(bookService.deleteBook(book), HttpStatus.OK);
    }

    @PostMapping(path = "/delete/id")
    public ResponseEntity<Book> deleteBookById(@Min(1) int id) {
        return new ResponseEntity<>(bookService.deleteBookById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/update/title")
    public ResponseEntity<Book> updateBookTitle(@RequestBody @Valid Book book, @Min(1) int id) {
        return new ResponseEntity<>(bookService.updateBookTitle(book, id), HttpStatus.OK);
    }

    @PostMapping(path = "/update/description")
    public ResponseEntity<Book> updateBookDescription(@RequestBody @Valid Book book, @Min(1) int id) {
        return new ResponseEntity<>(bookService.updateBookDescription(book, id), HttpStatus.OK);
    }

    @PostMapping(path = "/update/price")
    public ResponseEntity<Book> updateBookPrice(@RequestBody @Valid Book book, @Min(1) int id) {
        return new ResponseEntity<>(bookService.updateBookPrice(book, id), HttpStatus.OK);
    }

    @PostMapping(path = "/update/author")
    public ResponseEntity<Book> updateBookAuthor(@RequestBody @Valid Book book, @Min(1) int id) {
        return new ResponseEntity<>(bookService.updateBookByAuthor(book, id), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all/books")
    public ResponseEntity<List<Book>> findAllBooks() {
        return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all/author")
    public ResponseEntity<List<Book>> findBooksByAuthor(@RequestBody @Valid Author author) {
        return new ResponseEntity<>(bookService.findBooksByAuthor(author), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all/price")
    public ResponseEntity<List<Book>> findBooksByPrice(@Min(1) BigDecimal price) {
        return new ResponseEntity<>(bookService.findBooksByPrice(price), HttpStatus.OK);
    }

    @GetMapping(path = "/find/id")
    public ResponseEntity<Book> findBooksById(@Min(1) int id) {
        return new ResponseEntity<>(bookService.findBookById(id), HttpStatus.OK);
    }

}

package by.bookstoreboot.bookstoreboot.service;

import by.bookstoreboot.bookstoreboot.entity.Author;

import java.util.List;

public interface AuthorService {

    Author add(Author name);
    Author deleteAuthor(Author name);
    Author deleteAuthorById(int id);
    Author updateAuthor(Author author);
    List<Author> findAllAuthors();
    Author findAuthorByName(String name);
    Author findAuthorById(int id);

}

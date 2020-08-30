package by.bookstoreboot.bookstoreboot.service;

import by.bookstoreboot.bookstoreboot.entity.Author;
import by.bookstoreboot.bookstoreboot.entity.Book;

import java.math.BigDecimal;
import java.util.List;

public interface BookService {

    Book save(Book book);

    Book deleteBook(Book book);

    Book deleteBookById(int id);

    Book updateBookTitle(Book book, int id);

    Book updateBookDescription(Book book, int id);

    Book updateBookPrice(Book book, int id);

    Book updateBookByAuthor(Book book, int id);

    List<Book> findAllBooks();

    List<Book> findBooksByAuthor(Author author);

    List<Book> findBooksByPrice(BigDecimal price);

    Book findBookById(int id);

}

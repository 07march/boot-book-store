package by.bookstoreboot.bookstoreboot.repository;

import by.bookstoreboot.bookstoreboot.entity.Author;
import by.bookstoreboot.bookstoreboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findBooksByAuthor(Author author);

    List<Book> findBooksByPrice(BigDecimal price);

}

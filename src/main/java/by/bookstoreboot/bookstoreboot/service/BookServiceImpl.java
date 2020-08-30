package by.bookstoreboot.bookstoreboot.service;

import by.bookstoreboot.bookstoreboot.entity.Author;
import by.bookstoreboot.bookstoreboot.entity.Book;
import by.bookstoreboot.bookstoreboot.repository.AuthorRepository;
import by.bookstoreboot.bookstoreboot.repository.BookRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Data
@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        Author author = authorRepository.findById(book.getAuthor().getId()).get();
        authorRepository.save(author);
        return bookRepository.save(book);
    }

    @Override
    public Book deleteBook(Book book) {
        bookRepository.delete(book);
        return null;
    }

    @Override
    public Book deleteBookById(int id) {
        bookRepository.deleteById(id);
        return null;
    }

    @Override
    public Book updateBookTitle(Book book, int id) {
        Book book1 = bookRepository.findById(id).get();
        if (book.getTitle() != null) {
            book1.setTitle(book.getTitle());
        }
        return bookRepository.save(book);
    }

    @Override
    public Book updateBookDescription(Book book, int id) {
        Book book1 = bookRepository.findById(id).get();
        if (book.getDescription() != null) {
            book1.setDescription(book.getDescription());
        }
        return bookRepository.save(book);
    }

    @Override
    public Book updateBookPrice(Book book, int id) {
        Book book1 = bookRepository.findById(id).get();
        if (book.getPrice() != null) {
            book1.setPrice(book.getPrice());
        }
        return bookRepository.save(book);
    }

    @Override
    public Book updateBookByAuthor(Book book, int id) {
        Book book1 = bookRepository.findById(id).get();
        if (book.getAuthor() != null) {
            authorRepository.save(book.getAuthor());
            book1.setAuthor(book.getAuthor());
        }
        return bookRepository.save(book);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> findBooksByAuthor(Author author) {
        return bookRepository.findBooksByAuthor(author);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> findBooksByPrice(BigDecimal price) {
        return bookRepository.findBooksByPrice(price);
    }

    @Override
    @Transactional(readOnly = true)
    public Book findBookById(int id) {
        return bookRepository.findById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }
}

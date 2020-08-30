package by.bookstoreboot.bookstoreboot.service;

import by.bookstoreboot.bookstoreboot.entity.Author;
import by.bookstoreboot.bookstoreboot.repository.AuthorRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Data
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public Author add(Author name) {
        return authorRepository.save(name);
    }

    @Override
    public Author deleteAuthor(Author name) {
        authorRepository.delete(name);
        return null;
    }

    @Override
    public Author deleteAuthorById(int id) {
        authorRepository.deleteById(id);
        return null;
    }

    @Override
    public Author updateAuthor(Author name) {
        Author byId = authorRepository.findById(name.getId()).get();
        if (name.getName() != null){
            byId.setName(name.getName());
        }
        return authorRepository.save(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Author findAuthorByName(String name) {
        return authorRepository.findAuthorByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Author findAuthorById(int id) {
        return authorRepository.findById(id).get();
    }
}

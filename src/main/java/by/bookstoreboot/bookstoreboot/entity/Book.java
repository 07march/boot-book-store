package by.bookstoreboot.bookstoreboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue
    private int id;

    @Max(value = 100, message = "price can't be more then 100$")
    private BigDecimal price;

    @OneToOne
    @NotNull(message = "author is not null")
    private Author author;

    @NotNull(message = "title is not null")
    @NotEmpty(message = "not empty! enter some characters")
    private String title;

    @Size(min = 5, message = "enter more then 5 characters!")
    @NotNull(message = "description is not null")
    @NotEmpty(message = "not empty! enter some characters")
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(price, book.price) &&
                Objects.equals(author, book.author) &&
                Objects.equals(title, book.title) &&
                Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, author, title, description);
    }
}

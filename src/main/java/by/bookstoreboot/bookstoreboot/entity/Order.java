package by.bookstoreboot.bookstoreboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
//    @EmbeddedId
    @GeneratedValue
    private Key id;

    @OneToMany
    private List<Book> books;

//    @OneToOne
//    private Address address;

    @OneToOne
    private Store store;

    @OneToOne
    private User user;

    @Max(value = 100, message = "max price 100$")
    private BigDecimal totalPrice;

    @NotNull(message = "not null! enter ACTIVE or CLOSE")
    private Status status;

    @NotNull
    private Type type;

}

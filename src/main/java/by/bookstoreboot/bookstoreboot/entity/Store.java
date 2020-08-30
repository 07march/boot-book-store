package by.bookstoreboot.bookstoreboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Store {

    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "store is not null")
    private String store;

    @NotNull(message = "address is not null")
    @OneToOne
    private Address address;

    @NotNull(message = "city is not null")
    @OneToOne
    private City city;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store1 = (Store) o;
        return Objects.equals(store, store1.store) &&
                Objects.equals(address, store1.address) &&
                Objects.equals(city, store1.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(store, address, city);
    }
}

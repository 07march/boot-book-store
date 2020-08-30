package by.bookstoreboot.bookstoreboot.repository;

import by.bookstoreboot.bookstoreboot.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAllByStatus(Status status);
    List<Order> findAllByStore(Store store);
//    List<Order> findAllByAddress(Address address);
    List<Order> findAllByUser(User user);

}

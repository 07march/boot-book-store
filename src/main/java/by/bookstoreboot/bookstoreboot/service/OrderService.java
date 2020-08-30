package by.bookstoreboot.bookstoreboot.service;

import by.bookstoreboot.bookstoreboot.entity.*;

import java.util.List;

public interface OrderService {

    Order saveOrder(Order order);
    Order deleteOrder(Order order);
    Order deleteOrderById(int id);
    Order updateBookInOrder(Order order, int id);
    Order updateStatusInOrder(Order order, int id);
    Order updateAddressInOrder(Order order, int id);
    Order updateStoreInOrder(Order order, int id);
    List<Order> findAll();
    List<Order> findAllByStatus(Status status);
    List<Order> findAllByStore(Store store);
    List<Order> findAllByAddress(Address address);
    List<Order> findAllByUser(User user);

}

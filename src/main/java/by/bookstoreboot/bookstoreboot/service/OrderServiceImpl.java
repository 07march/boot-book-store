package by.bookstoreboot.bookstoreboot.service;

import by.bookstoreboot.bookstoreboot.entity.*;
import by.bookstoreboot.bookstoreboot.repository.BookRepository;
import by.bookstoreboot.bookstoreboot.repository.OrderRepository;
import by.bookstoreboot.bookstoreboot.repository.StoreRepository;
import by.bookstoreboot.bookstoreboot.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final StoreRepository storeRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;

    @Override
    public Order saveOrder(Order order) {
        if (order.getType().equals(Type.DELIVERY)) {
//            by.bookstoreboot.bookstoreboot.User byID = userRepository.findById(order.getUser().getId()).get();
//            order.setUser(byID);
//            userRepository.save(order.getUser());
            order.setStatus(Status.ACTIVE);
            return orderRepository.save(order);
        } else {
//            Store store = storeRepository.findById(order.getStore().getId()).get();
//            order.setStore(store);
//            storeRepository.save(order.getStore());
//            by.bookstoreboot.bookstoreboot.User byID = userRepository.findById(order.getUser().getId()).get();
//            order.setUser(byID);
//            userRepository.save(order.getUser());
            order.setStatus(Status.ACTIVE);
            return orderRepository.save(order);
        }
    }

    @Override
    public Order deleteOrder(Order order) {
        orderRepository.delete(order);
        return null;
    }

    @Override
    public Order deleteOrderById(int id) {
        orderRepository.deleteById(id);
        return null;
    }

    @Override
    public Order updateBookInOrder(Order order, int id) {
        Order order1 = orderRepository.findById(id).get();
        if (order.getBooks() != null) {
            order1.setBooks(order.getBooks());
        }
        return orderRepository.save(order);
    }

    @Override
    public Order updateStatusInOrder(Order order, int id) {
        Order order1 = orderRepository.findById(id).get();
        if (order.getStatus() != null) {
            order1.setStatus(order.getStatus());
        }
        return orderRepository.save(order);
    }

    @Override
    public Order updateAddressInOrder(Order order, int id) {
        Order order1 = orderRepository.findById(id).get();
//        if (order.getAddress() != null) {
//            order1.setAddress(order.getAddress());
//        }
        return orderRepository.save(order);
    }

    @Override
    public Order updateStoreInOrder(Order order, int id) {
        Order order1 = orderRepository.findById(id).get();
        if (order.getStore() != null) {
            order1.setStore(order.getStore());
        }
        return orderRepository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findAllByStatus(Status status) {
        return orderRepository.findAllByStatus(status);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findAllByStore(Store store) {
        return orderRepository.findAllByStore(store);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findAllByAddress(Address address) {
//        return orderRepository.findAllByAddress(address);
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findAllByUser(User user) {
        return orderRepository.findAllByUser(user);
    }
}

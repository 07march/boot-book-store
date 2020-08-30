package by.bookstoreboot.bookstoreboot.controller;

import by.bookstoreboot.bookstoreboot.entity.*;
import by.bookstoreboot.bookstoreboot.service.KeyService;
import by.bookstoreboot.bookstoreboot.service.OrderService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.UUID;

@RestController
@Validated
@RequestMapping(path = "/order")
@Data
public class OrderController {

    private final OrderService orderService;
    private final KeyService keyService;

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody @Valid Order order, @RequestHeader("token") String key) {
        Key keyByUuid = keyService.findKeyByUuid(UUID.fromString(key));
        if (keyByUuid == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        if (keyByUuid.getRole().equals(Role.ADMIN)) {
            return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<Order> delete(@RequestBody @Valid Order order) {
        return new ResponseEntity<>(orderService.deleteOrder(order), HttpStatus.CREATED);
    }

    @PostMapping(path = "/delete/id")
    public ResponseEntity<Order> deleteById(@Min(1) int id) {
        return new ResponseEntity<>(orderService.deleteOrderById(id), HttpStatus.CREATED);
    }

    @PostMapping(path = "/update/book")
    public ResponseEntity<Order> updateBookInOrder(@RequestBody @Valid Order order, @Min(1) int id) {
        return new ResponseEntity<>(orderService.updateBookInOrder(order, id), HttpStatus.CREATED);
    }

    @PostMapping(path = "/update/status")
    public ResponseEntity<Order> updateStatusInOrder(@RequestBody @Valid Order order, @Min(1) int id) {
        return new ResponseEntity<>(orderService.updateStatusInOrder(order, id), HttpStatus.CREATED);
    }

    @PostMapping(path = "/update/address")
    public ResponseEntity<Order> updateAddressInOrder(@RequestBody @Valid Order order, @Min(1) int id) {
        return new ResponseEntity<>(orderService.updateAddressInOrder(order, id), HttpStatus.CREATED);
    }

    @PostMapping(path = "/update/store")
    public ResponseEntity<Order> updateStoreInOrder(@RequestBody @Valid Order order, @Min(1) int id) {
        return new ResponseEntity<>(orderService.updateStoreInOrder(order, id), HttpStatus.CREATED);
    }

    @GetMapping(path = "/find/all/by/store")
    public ResponseEntity<List<Order>> findAllOrdersStore(@RequestBody @Valid Store store) {
        return new ResponseEntity<>(orderService.findAllByStore(store), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all/by/address")
    public ResponseEntity<List<Order>> findAllOrdersAddress(@RequestBody @Valid Address address) {
        return new ResponseEntity<>(orderService.findAllByAddress(address), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all/by/user")
    public ResponseEntity<List<Order>> findAllOrdersUser(@RequestBody @Valid User user) {
        return new ResponseEntity<>(orderService.findAllByUser(user), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all/by/status")
    public ResponseEntity<List<Order>> findAllOrdersStatus(@RequestBody @Valid Status status) {
        return new ResponseEntity<>(orderService.findAllByStatus(status), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all")
    public ResponseEntity<List<Order>> findAllOrders() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }
}

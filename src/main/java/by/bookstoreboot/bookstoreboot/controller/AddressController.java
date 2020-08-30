package by.bookstoreboot.bookstoreboot.controller;

import by.bookstoreboot.bookstoreboot.entity.Address;
import by.bookstoreboot.bookstoreboot.service.AddressService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/address")
@Validated
@Data
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<Address> addAddress(@Valid @RequestBody Address address) {
        return new ResponseEntity<>(addressService.addAddress(address), HttpStatus.CREATED);
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<Address> deleteAddress(@RequestBody @Valid Address address) {
        return new ResponseEntity<>(addressService.deleteAddress(address), HttpStatus.OK);
    }

    @PostMapping(path = "/delete/id")
    public ResponseEntity<Address> deleteAddressById(@Min(1) int id) {
        return new ResponseEntity<>(addressService.deleteAddressById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<Address> updateAddress(@RequestBody @Valid Address address) {
        return new ResponseEntity<>(addressService.updateAddress(address), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all")
    public ResponseEntity<List<Address>> findAll() {
        return new ResponseEntity<>(addressService.findAllAddresses(), HttpStatus.OK);
    }

    @GetMapping(path = "/find/name")
    public ResponseEntity<Address> findAddress(@RequestParam @NotEmpty @NotBlank String address) {
        return new ResponseEntity<>(addressService.findAddress(address), HttpStatus.OK);
    }

    @GetMapping(path = "/find/id")
    public ResponseEntity<Address> findAddressById(@Min(1) int id) {
        return new ResponseEntity<>(addressService.findAddressById(id), HttpStatus.OK);
    }
}

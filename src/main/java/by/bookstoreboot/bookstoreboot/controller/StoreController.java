package by.bookstoreboot.bookstoreboot.controller;

import by.bookstoreboot.bookstoreboot.entity.Store;
import by.bookstoreboot.bookstoreboot.service.StoreService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@RequestMapping(path = "/store")
@Validated
@Data
public class StoreController {

    private final StoreService storeService;

    @PostMapping
    public ResponseEntity<Store> addStore(@RequestBody @Valid Store store) {
        return new ResponseEntity<>(storeService.addStore(store), HttpStatus.CREATED);
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<Store> deleteStore(@RequestBody @Valid Store store) {
        return new ResponseEntity<>(storeService.deleteStore(store), HttpStatus.OK);
    }

    @PostMapping(path = "/delete/id")
    public ResponseEntity<Store> deleteStoreById(@Min(1) int id) {
        return new ResponseEntity<>(storeService.deleteStoreById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/update/name")
    public ResponseEntity<Store> updateStoreName(@RequestBody @Valid Store storeName,@Min(1)  int id) {
        return new ResponseEntity<>(storeService.updateStoreName(storeName, id), HttpStatus.OK);
    }

    @PostMapping(path = "/update/address")
    public ResponseEntity<Store> updateStoreAddress(@RequestBody @Valid Store storeAddress,@Min(1)  int id) {
        return new ResponseEntity<>(storeService.updateStoreAddress(storeAddress, id), HttpStatus.OK);
    }

    @PostMapping(path = "/update/city")
    public ResponseEntity<Store> updateStoreCity(@RequestBody @Valid Store storeCity,@Min(1)  int id) {
        return new ResponseEntity<>(storeService.updateStoreCity(storeCity, id), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all")
    public ResponseEntity<List<Store>> findAll() {
        return new ResponseEntity<>(storeService.findAllStores(), HttpStatus.OK);
    }

    @GetMapping(path = "/find/name")
    public ResponseEntity<Store> findStoreByName(@RequestParam @NotEmpty @NotBlank String storeName) {
        return new ResponseEntity<>(storeService.findStore(storeName), HttpStatus.OK);
    }

    @GetMapping(path = "/find/address")
    public ResponseEntity<Store> findStoreByAddress(@RequestBody @Valid Store storeAddress) {
        return new ResponseEntity<>(storeService.findStoreByAddress(storeAddress), HttpStatus.OK);
    }

    @GetMapping(path = "/find/city")
    public ResponseEntity<Store> findStoreByCity(@RequestBody @Valid Store storeCity) {
        return new ResponseEntity<>(storeService.findStoreByCity(storeCity), HttpStatus.OK);
    }

    @GetMapping(path = "/find/id")
    public ResponseEntity<Store> findStoreById(@Min(1) int id) {
        return new ResponseEntity<>(storeService.findStoreById(id), HttpStatus.OK);
    }
}

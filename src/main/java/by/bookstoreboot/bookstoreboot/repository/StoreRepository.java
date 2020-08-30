package by.bookstoreboot.bookstoreboot.repository;

import by.bookstoreboot.bookstoreboot.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Integer> {

    Store findStoreByStore(String storeName);

    Store findStoreByAddress(Store storeAddress);

    Store findStoreByCity(Store storeCity);

}

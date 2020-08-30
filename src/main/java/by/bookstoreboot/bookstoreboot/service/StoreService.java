package by.bookstoreboot.bookstoreboot.service;

import by.bookstoreboot.bookstoreboot.entity.Store;

import java.util.List;

public interface StoreService {

    Store addStore(Store store);
    Store deleteStore(Store store);
    Store deleteStoreById(int id);
    Store updateStoreName(Store storeName, int id);
    Store updateStoreAddress(Store storeAddress, int id);
    Store updateStoreCity(Store storeCity, int id);
    List<Store> findAllStores();
    Store findStore(String storeName);
    Store findStoreByAddress(Store storeAddress);
    Store findStoreByCity(Store storeCity);
    Store findStoreById(int id);

}

package by.bookstoreboot.bookstoreboot.service;

import by.bookstoreboot.bookstoreboot.entity.Address;
import by.bookstoreboot.bookstoreboot.entity.City;
import by.bookstoreboot.bookstoreboot.entity.Store;
import by.bookstoreboot.bookstoreboot.repository.AddressRepository;
import by.bookstoreboot.bookstoreboot.repository.CityRepository;
import by.bookstoreboot.bookstoreboot.repository.StoreRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Data
@Service
@Transactional
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final CityRepository cityRepository;
    private final AddressRepository addressRepository;

    @Override
    public Store addStore(Store store) {
        City cityId = cityRepository.findById(store.getCity().getId()).get();
        Address addressId = addressRepository.findById(store.getAddress().getId()).get();
        cityRepository.save(cityId);
        addressRepository.save(addressId);
        return storeRepository.save(store);
    }

    @Override
    public Store deleteStore(Store store) {
        storeRepository.delete(store);
        return null;
    }

    @Override
    public Store deleteStoreById(int id) {
        storeRepository.deleteById(id);
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Store> findAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public Store updateStoreName(Store storeName, int id) {
        Store store = storeRepository.findById(id).get();
        if (storeName.getStore() != null){
            store.setStore(storeName.getStore());
        }
        return storeRepository.save(storeName);
    }

    @Override
    public Store updateStoreAddress(Store storeAddress, int id) {
        Store store = storeRepository.findById(id).get();
        if (storeAddress.getAddress() != null){
            addressRepository.save(storeAddress.getAddress());
            store.setAddress(storeAddress.getAddress());
        }
        return storeRepository.save(storeAddress);
    }

    @Override
    public Store updateStoreCity(Store storeCity, int id) {
        Store store = storeRepository.findById(id).get();
        if (storeCity.getCity() != null){
            cityRepository.save(storeCity.getCity());
            store.setCity(storeCity.getCity());
        }
        return storeRepository.save(storeCity);
    }

    @Override
    @Transactional(readOnly = true)
    public Store findStore(String storeName) {
        return storeRepository.findStoreByStore(storeName);
    }

    @Override
    @Transactional(readOnly = true)
    public Store findStoreByAddress(Store storeAddress) {
        return storeRepository.findStoreByAddress(storeAddress);
    }

    @Override
    @Transactional(readOnly = true)
    public Store findStoreByCity(Store storeCity) {
        return storeRepository.findStoreByCity(storeCity);
    }

    @Override
    @Transactional(readOnly = true)
    public Store findStoreById(int id) {
        return storeRepository.findById(id).get();
    }
}

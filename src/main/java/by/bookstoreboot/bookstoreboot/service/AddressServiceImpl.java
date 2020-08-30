package by.bookstoreboot.bookstoreboot.service;

import by.bookstoreboot.bookstoreboot.entity.Address;
import by.bookstoreboot.bookstoreboot.repository.AddressRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Data
@Transactional
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address deleteAddress(Address address) {
        addressRepository.delete(address);
        return null;
    }

    @Override
    public Address deleteAddressById(int id) {
        addressRepository.deleteById(id);
        return null;
    }

    @Override
    public Address updateAddress(Address address) {
        Address byId = addressRepository.findById(address.getId()).get();
        if (address.getAddress() != null) {
            byId.setAddress(address.getAddress());
        }
        return addressRepository.save(address);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Address> findAllAddresses() {
        return addressRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Address findAddress(String address) {
        return addressRepository.findAddressByAddress(address);
    }

    @Override
    @Transactional(readOnly = true)
    public Address findAddressById(int id) {
        return addressRepository.findById(id).get();
    }
}

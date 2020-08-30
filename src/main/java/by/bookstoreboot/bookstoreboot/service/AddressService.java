package by.bookstoreboot.bookstoreboot.service;

import by.bookstoreboot.bookstoreboot.entity.Address;

import java.util.List;

public interface AddressService {

    Address addAddress(Address address);
    Address deleteAddress(Address address);
    Address deleteAddressById(int id);
    Address updateAddress(Address address);
    List<Address> findAllAddresses();
    Address findAddress(String address);
    Address findAddressById(int id);

}

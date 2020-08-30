package by.bookstoreboot.bookstoreboot.service;

import by.bookstoreboot.bookstoreboot.entity.City;

import java.util.List;

public interface CityService {

    City addCity(City city);
    City deleteCity(City city);
    City deleteCityById(int id);
    City updateCity(City city);
    List<City> findAllCities();
    City findCityByName(String city);
    City findCityById(int id);

}

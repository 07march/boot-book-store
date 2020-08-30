package by.bookstoreboot.bookstoreboot.repository;

import by.bookstoreboot.bookstoreboot.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {

    City findCityByCity(String city);

}

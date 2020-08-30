package by.bookstoreboot.bookstoreboot.service;

import by.bookstoreboot.bookstoreboot.entity.City;
import by.bookstoreboot.bookstoreboot.repository.CityRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Data
@Service
@Transactional
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City deleteCity(City city) {
        cityRepository.delete(city);
        return null;
    }

    @Override
    public City deleteCityById(int id) {
        cityRepository.deleteById(id);
        return null;
    }

    @Override
    public City updateCity(City city) {
        City byId = cityRepository.findById(city.getId()).get();
        if (city.getCity() != null) {
            byId.setCity(city.getCity());
        }
        return cityRepository.save(city);
    }

    @Override
    @Transactional(readOnly = true)
    public List<City> findAllCities() {
        return cityRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public City findCityByName(String city) {
        return cityRepository.findCityByCity(city);
    }

    @Override
    @Transactional(readOnly = true)
    public City findCityById(int id) {
        return cityRepository.findById(id).get()
                ;
    }


}

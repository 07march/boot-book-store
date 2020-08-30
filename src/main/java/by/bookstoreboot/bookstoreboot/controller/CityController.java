package by.bookstoreboot.bookstoreboot.controller;

import by.bookstoreboot.bookstoreboot.entity.City;
import by.bookstoreboot.bookstoreboot.service.CityService;
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
@RequestMapping(path = "/city")
@Validated
@Data
public class CityController {

    private final CityService cityService;

    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody @Valid City city) {
        return new ResponseEntity<>(cityService.addCity(city), HttpStatus.CREATED);
    }

    @PostMapping(path = "/delete")
    public ResponseEntity<City> deleteCity(@RequestBody @Valid City city) {
        return new ResponseEntity<>(cityService.deleteCity(city), HttpStatus.OK);
    }

    @PostMapping(path = "/delete/id")
    public ResponseEntity<City> deleteCityById(@Min(1) int id) {
        return new ResponseEntity<>(cityService.deleteCityById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<City> updateCity(@RequestBody @Valid City city) {
        return new ResponseEntity<>(cityService.updateCity(city), HttpStatus.OK);
    }

    @GetMapping(path = "/find/all")
    public ResponseEntity<List<City>> findAll() {
        return new ResponseEntity<>(cityService.findAllCities(), HttpStatus.OK);
    }

    @GetMapping(path = "/find/name")
    public ResponseEntity<City> findCityByName(@RequestParam @NotEmpty @NotBlank String city) {
        return new ResponseEntity<>(cityService.findCityByName(city), HttpStatus.OK);
    }

    @GetMapping(path = "/find/id")
    public ResponseEntity<City> findCityById(@Min(1) int id) {
        return new ResponseEntity<>(cityService.findCityById(id), HttpStatus.OK);
    }
}

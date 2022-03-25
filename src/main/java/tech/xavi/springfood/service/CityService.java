package tech.xavi.springfood.service;

import org.springframework.stereotype.Component;
import tech.xavi.springfood.models.City;

import java.util.List;


public interface CityService {

    List<City> getAllCities();
}

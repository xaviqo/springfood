package tech.xavi.springfood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.xavi.springfood.models.City;
import tech.xavi.springfood.repository.CityRepository;

import java.util.List;

@Component
public class CityServiceImp implements CityService{

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

}

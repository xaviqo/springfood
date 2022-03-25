package tech.xavi.springfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.xavi.springfood.models.City;

public interface CityRepository extends JpaRepository<City,Long> {

}

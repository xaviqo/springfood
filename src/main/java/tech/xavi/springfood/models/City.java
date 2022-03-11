package tech.xavi.springfood.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class City {

    @Column(name = "postal") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postal;

    @Column(name = "city")
    private String city;

}

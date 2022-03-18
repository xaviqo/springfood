package tech.xavi.springfood.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "city")
public class City {

    @Column(name = "postal", length = 5) @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String postal;

    @Column(name = "name", length = 40, nullable = false)
    private String cityName;

}

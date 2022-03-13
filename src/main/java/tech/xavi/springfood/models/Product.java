package tech.xavi.springfood.models;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class Product {

    //TODO como gestionar imagen? Probar con ID ex: id=1337 img/prod/1337.jpg?

    @Column(name = "id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "type")
    private String type;

    @Column(name = "stock")
    private int stock;

    @Column(name = "active")
    private boolean active;


}

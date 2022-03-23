package tech.xavi.springfood.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "product")
public class Product {

    //TODO como gestionar imagen? Probar con ID ex: id=1337 img/prod/1337.jpg?

    @Column(name = "product_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type", length = 40)
    private String type;

    @Column(name = "stock")
    private int stock;

    @Column(name = "price")
    private double price;

    @Column(name = "active")
    private boolean active;


}

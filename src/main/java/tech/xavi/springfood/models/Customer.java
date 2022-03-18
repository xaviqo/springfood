package tech.xavi.springfood.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    //TODO: Añadir nullable y length

    @Column(name = "account") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 40, nullable = false)
    private String customerName;

    @Column(name = "phone", length = 40, nullable = false)
    private String phone;

    @OneToOne
    @JoinColumn(name = "city")
    private City city;

    @Column(name = "street", length = 40, nullable = false)
    private String street;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Account account;
}

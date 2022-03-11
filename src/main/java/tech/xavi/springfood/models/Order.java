package tech.xavi.springfood.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {

    @Getter @Setter
    @Column(name = "id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter @Setter
    @Column(name = "client")
    private int client;

    @Getter @Setter
    private int lines;

    @Getter @Setter
    @Column(name = "date")
    private LocalDateTime date;

    @Getter @Setter
    @Column(name = "city")
    private String city;

    @Getter @Setter
    @Column(name = "street")
    private String street;

    @Getter @Setter
    @Column(name = "total")
    private double total;

    @Getter @Setter
    @Column(name = "sale")
    private int sale;

    @Getter @Setter
    @Column(name = "state")
    private boolean state;
}

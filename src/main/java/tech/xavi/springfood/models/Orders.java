package tech.xavi.springfood.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class Orders {

    @Column(name = "id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "total")
    private double total;

    @Column(name = "sale")
    private int sale;

    @Column(name = "line_count")
    private int lines;

    @Column(name = "state")
    private boolean state;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client")
    private Client client;

}

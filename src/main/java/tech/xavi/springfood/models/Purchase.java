package tech.xavi.springfood.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "purchase")
public class Purchase {

    @Column(name = "purchase_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "discount")
    private short discount;

    @Column(name = "total")
    private double total;

    @Column(name = "is_delivered", nullable = false)
    private boolean isDelivered;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer")
    private Customer customer;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL)
    private List<PurchaseLine> lines;

}

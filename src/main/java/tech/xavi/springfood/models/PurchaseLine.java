package tech.xavi.springfood.models;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "purchase_line")
public class PurchaseLine {

    @Column(name = "line_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "purchase")
    private long purchase;

    @OneToOne
    @JoinColumn(name = "product", nullable = false)
    private Product product;

    @Column(name = "amount", nullable = false)
    private short amount;

    @Column(name = "line_discount")
    private short discount;

    @Column(name = "total_line", nullable = false)
    private double total;

}

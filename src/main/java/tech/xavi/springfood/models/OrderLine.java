package tech.xavi.springfood.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_line")
public class OrderLine {

    @Column(name = "line") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "orderid")
    private int order;

    @Column(name = "product")
    private int product;

    @Column(name = "amount")
    private int amount;

    @Column(name = "total")
    private double total;

    @Column(name = "total_sale")
    private double totalSale;

    @Column(name = "line_sale")
    private int sale;

}

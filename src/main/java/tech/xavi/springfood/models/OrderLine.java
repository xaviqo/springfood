package tech.xavi.springfood.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class OrderLine {
    public OrderLine(int id, int order, int product, int amount, double total, double totalSale, int sale) {
        this.id = id;
        this.order = order;
        this.product = product;
        this.amount = amount;
        this.total = total;
        this.totalSale = totalSale;
        this.sale = sale;
    }

    @Column(name = "line") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "order")
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

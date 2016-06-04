package com.zegates.vozco.entities;

import javax.persistence.*;

/**
 * Created by sandaruwan on 3/15/16.
 */
@Entity
public class StockDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sdid;
    @OneToOne
    private FoodItem item;
    @ManyToOne
    private StockOrder stockOrder;

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    double qty;
}

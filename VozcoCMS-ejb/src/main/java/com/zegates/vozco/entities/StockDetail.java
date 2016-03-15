package com.zegates.vozco.entities;

/**
 * Created by sandaruwan on 3/15/16.
 */
public class StockDetail {

    private FoodItem item;
    private StockOrder stockOrder;

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    double qty;
}

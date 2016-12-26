package com.zegates.vozco.entities;

//import org.codehaus.jackson.annotate.JsonBackReference;
//import org.codehaus.jackson.annotate.JsonManagedReference;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * Created by sandaruwan on 3/15/16.
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="sdid", scope = StockDetail.class)
public class StockDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int sdid;
    @ManyToOne @JsonIdentityReference(alwaysAsId = false)
//    @JsonBackReference
    private FoodItem item;
    @ManyToOne @JsonIdentityReference(alwaysAsId = false)
//    @JsonBackReference
    private StockOrder stockOrder;
    double qty;
    @Column(precision = 10, scale = 2)
    double cost;
    @Column(precision = 10, scale = 2)
    double sellingPrice;
    @Column(precision = 10, scale = 2)
    double sellingPriceForeign;
    boolean isSelling;
    boolean isFinite;
    double remainingQty;

    public double getQty() {
        return qty;
    }
    public void setQty(double qty) {
        this.qty = qty;
    }
    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getSellingPriceForeign() {
        return sellingPriceForeign;
    }

    public void setSellingPriceForeign(double sellingPriceForeign) {
        this.sellingPriceForeign = sellingPriceForeign;
    }

    public boolean isSelling() {
        return isSelling;
    }

    public void setSelling(boolean selling) {
        isSelling = selling;
    }

    public boolean isFinite() {
        return isFinite;
    }

    public void setFinite(boolean finite) {
        isFinite = finite;
    }

    public double getRemainingQty() {
        return remainingQty;
    }

    public void setRemainingQty(double remainingQty) {
        this.remainingQty = remainingQty;
    }

    public int getSdid() {
        return sdid;
    }

    public void setSdid(int sdid) {
        this.sdid = sdid;
    }

    public FoodItem getItem() {
        return item;
    }

    public void setItem(FoodItem item) {
        this.item = item;
    }

    public StockOrder getStockOrder() {
        return stockOrder;
    }

    public void setStockOrder(StockOrder stockOrder) {
        this.stockOrder = stockOrder;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}

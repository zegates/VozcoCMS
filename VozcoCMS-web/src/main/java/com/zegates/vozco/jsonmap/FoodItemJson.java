package com.zegates.vozco.jsonmap;

import com.zegates.vozco.entities.FoodCategory;
import com.zegates.vozco.entities.Metric;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by sandaruwan on 7/16/16.
 */
public class FoodItemJson {

    private int fid;
    private String itemName;
    private Metric metric;
    private FoodCategory foodCategory;
    private String description;
    private double sellingPrice;
    private double foreignPrice;
    private double remainingQty;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Metric getMetric() {
        return metric;
    }

    public void setMetric(Metric metric) {
        this.metric = metric;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(FoodCategory foodCategory) {
        this.foodCategory = foodCategory;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getForeignPrice() {
        return foreignPrice;
    }

    public void setForeignPrice(double foreignPrice) {
        this.foreignPrice = foreignPrice;
    }

    public double getRemainingQty() {
        return remainingQty;
    }

    public void setRemainingQty(double remainingQty) {
        this.remainingQty = remainingQty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

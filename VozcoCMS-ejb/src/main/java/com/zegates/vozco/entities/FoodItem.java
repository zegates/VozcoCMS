package com.zegates.vozco.entities;

import javax.persistence.*;

/**
 * Created by sandaruwan on 3/15/16.
 */
@Entity
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int fid;
    private String itemName;
    @OneToOne
    private Metric metric;
    @ManyToOne
    private FoodCategory foodCategory;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }
}

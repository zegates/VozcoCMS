package com.zegates.vozco.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by sandaruwan on 3/28/16.
 */
@Entity
public class FoodCategory {
    @Id
    private int fcid;
    private String foodCatName;
    @OneToMany(mappedBy = "foodCategory")
    List<FoodItem> foodItems;

    public int getFcid() {
        return fcid;
    }

    public void setFcid(int fcid) {
        this.fcid = fcid;
    }

    public String getFoodCatName() {
        return foodCatName;
    }

    public void setFoodCatName(String foodCatName) {
        this.foodCatName = foodCatName;
    }

    public List<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}

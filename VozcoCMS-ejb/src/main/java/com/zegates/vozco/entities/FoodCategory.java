package com.zegates.vozco.entities;

//import org.codehaus.jackson.annotate.JsonIgnore;
//import org.codehaus.jackson.annotate.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by sandaruwan on 3/28/16.
 */
@Entity
@NamedQueries({
        @NamedQuery(
                name = "findFoodCategoryItems",
                query = "SELECT fc FROM FoodCategory fc WHERE fc.fcid=:fcID"
        )
})
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="fcid")
public class FoodCategory {
    @Id
    private int fcid;
    private String foodCatName;
    @OneToMany(mappedBy = "foodCategory") @JsonIdentityReference(alwaysAsId = true)// @JsonManagedReference
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

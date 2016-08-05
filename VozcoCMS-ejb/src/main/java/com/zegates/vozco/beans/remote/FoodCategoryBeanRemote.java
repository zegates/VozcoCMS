package com.zegates.vozco.beans.remote;

import com.zegates.vozco.entities.FoodCategory;
import com.zegates.vozco.entities.FoodItem;

import java.util.List;

/**
 * Created by sandaruwan on 3/28/16.
 */
public interface FoodCategoryBeanRemote {
    public List<FoodCategory> findFoodCategory();
    public List<FoodCategory> findFoodCategory(boolean all, int maxResults, int firstResult);
    public FoodCategory findFoodCategoryItems(FoodCategory foodCategory);
}

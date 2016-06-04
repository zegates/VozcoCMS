package com.zegates.vozco.beans.remote;

import com.zegates.vozco.entities.FoodItem;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by sandaruwan on 3/28/16.
 */
@Local
public interface FoodItemBeanRemote {
    public List<FoodItem> findFoodItem(boolean all, int maxResults, int firstResult);
    public List<FoodItem> findFoodItem();

}

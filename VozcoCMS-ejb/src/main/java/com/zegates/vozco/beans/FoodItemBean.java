package com.zegates.vozco.beans;

import com.zegates.vozco.beans.remote.FoodItemBeanRemote;
import com.zegates.vozco.entities.Customer;
import com.zegates.vozco.entities.FoodCategory;
import com.zegates.vozco.entities.FoodItem;
import com.zegates.vozco.util.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.logging.Level;

/**
 * Created by sandaruwan on 3/28/16.
 */
@Stateful//(name = "ItemBeanEJB")
public class FoodItemBean implements FoodItemBeanRemote{
    @PersistenceContext(unitName = "vozcopersist")
    private EntityManager em;

    @PostConstruct
    void init (){

    }

    public List<FoodItem> findFoodItem() {
        return findFoodItem(true, -1, -1);
    }

    public List<FoodItem> findFoodItem(int maxResults, int firstResult) {
        return findFoodItem(false, maxResults, firstResult);
    }

    @Override
    public List<FoodItem> findFoodItem(boolean all, int maxResults, int firstResult)  {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FoodItem.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }


    @Override
    public List<FoodItem> findFoodItemsForCategory(FoodCategory foodCategory) {
        try {
            Logger.log(Level.INFO, "Food Category Items Searching...");
            List<FoodItem> results = (List<FoodItem>) em.createNamedQuery("findFoodItemForCategory")
                    .setParameter("fcID", foodCategory)
                    .getResultList();
            return results;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}

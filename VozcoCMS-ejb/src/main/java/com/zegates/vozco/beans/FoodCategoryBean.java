package com.zegates.vozco.beans;

import com.zegates.vozco.beans.remote.FoodCategoryBeanRemote;
import com.zegates.vozco.entities.FoodCategory;
import com.zegates.vozco.entities.FoodItem;
import com.zegates.vozco.util.Logger;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
@Stateful //(name = "FoodCategoryEJB")
public class FoodCategoryBean implements FoodCategoryBeanRemote {
    @PersistenceContext(unitName = "vozcopersist")
    private EntityManager em;


    @PersistenceContext(unitName = "vozcopersist")
    private Session session;

    public FoodCategoryBean() {
    }

    @Override
    public List<FoodCategory> findFoodCategory() {
        return findFoodCategory(true, -1, -1);
    }

    public List<FoodCategory> findFoodCategory(int maxResults, int firstResult) {
        return findFoodCategory(false, maxResults, firstResult);
    }

    @Override
    public List<FoodCategory> findFoodCategory(boolean all, int maxResults, int firstResult)  {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FoodCategory.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public FoodCategory findFoodCategoryItems(FoodCategory foodCategory) {
        try {
            Logger.log(Level.INFO, "Food Category Items Searching...");

            List<FoodCategory> results= session.createCriteria(FoodCategory.class)
                    .add(Restrictions.eq("fcid", foodCategory.getFcid()))
                    .setFetchMode("foodItems", FetchMode.JOIN)
                    .createAlias("foodItems", "fi")
                    .setFetchMode("fi.stockDetails", FetchMode.JOIN)
                    .list();

//            List<FoodCategory> results = (List<FoodCategory>) em.createNamedQuery("findFoodCategoryItems")
//
//                    .setParameter("fcID", foodCategory.getFcid())
//                    .getResultList();
            if(results.size() > 0) {
                return results.get(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

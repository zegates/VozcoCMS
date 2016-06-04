package com.zegates.vozco.beans;

import com.zegates.vozco.beans.remote.FoodCategoryBeanRemote;
import com.zegates.vozco.entities.FoodCategory;
import com.zegates.vozco.entities.FoodItem;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by sandaruwan on 3/28/16.
 */
@Stateful //(name = "FoodCategoryEJB")
public class FoodCategoryBean implements FoodCategoryBeanRemote {
    @PersistenceContext(unitName = "vozcopersist")
    private EntityManager em;

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
        } finally {
            em.close();
        }
    }
}

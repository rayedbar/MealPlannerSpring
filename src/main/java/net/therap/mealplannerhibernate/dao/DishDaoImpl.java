package net.therap.mealplannerhibernate.dao;

import net.therap.mealplannerhibernate.entity.Dish;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author rayed
 * @since 11/14/16 11:39 AM
 */

@Repository
public class DishDaoImpl implements DishDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public List<Dish> viewDish() {
//        TypedQuery<> = em.createQuery("SELECT d FROM Dish d", Dish.class).getResultList();
//        System.out.println(dishList);
        return null;
    }

    @Override
    public void addDish(Dish dish) {

    }

    @Override
    public void deleteDish(int id) {

    }
}

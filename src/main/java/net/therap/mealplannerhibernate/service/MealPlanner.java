package net.therap.mealplannerhibernate.service;

import net.therap.mealplannerhibernate.entity.Dish;
import net.therap.mealplannerhibernate.entity.Meal;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rayed
 * @since 10/20/16 12:31 PM
 */

public class MealPlanner {

    private static SessionFactory sessionFactory;

    public MealPlanner() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    //TODO
    public void addMeal(String day, String type, String dishes){
        if (!mealPlanExists(day, type)){
            String[] dishNames = dishes.split(",");

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            List<Dish> dishList = new ArrayList<>();
            for (String dishName : dishNames){
                List<Dish> dishList1 = session.createQuery("from Dish where name = :dishName").setParameter("dishName", dishName.trim()).list();
                try {
                    dishList.add(dishList1.get(0));
                } catch (Exception e){
                    System.err.println("'" + dishName + "' doesn't exist!!!!");
                }

            }

            Meal meal = new Meal(day, type, dishList);

            session.saveOrUpdate(meal);
            session.getTransaction().commit();
            session.close();
        } else {
            System.out.println("Either meal plan exists or invalid. Try again");
        }
    }


    private boolean mealPlanExists(String day, String type) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Meal where day = :day and type = :type");
        query.setParameter("day", day);
        query.setParameter("type", type);
        List<Meal> mealList = query.list();

        session.getTransaction().commit();
        session.close();

        if (mealList.size() == 0){
            return false;
        }
        return true;
    }


    public List<Meal> getMeal() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Meal> list = session.createQuery("FROM Meal ORDER BY day asc").list();

        session.getTransaction().commit();
        session.close();
        return list;
    }

    public void updateMeal(int mealId, String day, String type) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Meal meal = session.get(Meal.class, mealId);
        meal.setDay(day);
        meal.setType(type);

        session.update(meal);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteMeal(int mealId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("delete from Meal where id = :mealId");
        query.setParameter("mealId", mealId);
        query.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}

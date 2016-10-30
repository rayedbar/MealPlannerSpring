package net.therap.mealplannerhibernate.service;

import net.therap.mealplannerhibernate.entity.Dish;
import net.therap.mealplannerhibernate.entity.Meal;
import net.therap.mealplannerhibernate.util.Display;
import net.therap.mealplannerhibernate.util.Input;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.Iterator;
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


    public void addMeal() {
        DishPlanner dishPlanner = new DishPlanner();
        dishPlanner.viewDish();

        System.out.println("Enter Day");
        String day = Input.getStringInput();
        System.out.println("Enter Breakfast/Lunch/Dinner");
        String type = Input.getStringInput();

        if (mealPlanExists(day, type)){
            System.out.println("Enter comma separated names");
            String input = Input.getStringInput();
            String[] dishNames = input.split(",");

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

            session.save(meal);
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

        //System.out.println(list.get(0).getDay());

        return list;
    }

    public void updateMeal() {
        getMeal();

        DishPlanner dishPlanner = new DishPlanner();
        dishPlanner.viewDish();

        System.out.println("Enter day");
        String day = Input.getStringInput();
        System.out.println("Enter type");
        String type = Input.getStringInput();
        System.out.println("Enter dish name to update");
        String oldDishName = Input.getStringInput();
        System.out.println("Enter new dish name as per dish list");
        String newDishName = Input.getStringInput();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Meal where day = :day and type = :type");
        query.setParameter("day", day);
        query.setParameter("type", type);

        List<Meal> mealList = query.list();
        Meal meal = mealList.get(0);

        List<Dish> dishList = meal.getDishList();

        for (Dish dish : dishList) {
            if (dish.getName().equals(oldDishName)) {
                dishList.remove(dish);
                break;
            }
        }

        Query q = session.createQuery("from Dish where name = :newDishName");
        q.setParameter("newDishName", newDishName);

        List<Dish> list = q.list();
        dishList.add(list.get(0));
        meal.setDishList(dishList);

        session.update(meal);
        session.getTransaction().commit();
        session.close();
    }

    public void viewMealByDay() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        System.out.println("enter day whose meal you want to view");
        String dayName = Input.getStringInput();

        Query query = session.createQuery("from Meal where day = :day");
        query.setParameter("day", dayName);

        List<Meal> mealList = query.list();

        try {
            System.out.println(mealList.get(0).getDay().toUpperCase() + ":");
            for (Meal meal : mealList) {
                System.out.print(meal.getType() + ": ");
                List<Dish> dishList = meal.getDishList();
                Iterator<Dish> iterator = dishList.iterator();
                for (Dish dish : dishList) {
                    System.out.print(dish.getName() + ", ");
                }
                System.out.println();
            }
        } catch (Exception e){
            System.err.println(dayName + " Invalid or doesn't exist yet");
        }
    }

    public void viewMealByType() {
        System.out.println("Enter type");
        String type = Input.getStringInput();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from Meal where type = :type");
        query.setParameter("type", type);

        List<Meal> list = query.list();

        session.getTransaction().commit();
        session.close();

        Display.diplayMealByType(list);
    }
}

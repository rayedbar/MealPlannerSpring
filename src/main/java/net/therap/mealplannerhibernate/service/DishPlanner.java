package net.therap.mealplannerhibernate.service;

import net.therap.mealplannerhibernate.entity.Dish;
import net.therap.mealplannerhibernate.util.Display;
import net.therap.mealplannerhibernate.util.Input;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

/**
 * @author rayed
 * @since 10/20/16 11:51 AM
 */

public class DishPlanner {

    private static SessionFactory sessionFactory;

    public DishPlanner(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    public void addDish(){
        System.out.println("Enter name of dish");
        String dish_name = Input.getStringInput();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Dish(dish_name));
        session.getTransaction().commit();
        session.close();
    }


    public void viewDish(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Dish> dishList = session.createQuery("FROM Dish").list();

        session.getTransaction().commit();
        session.close();

        Display.displayDish(dishList);
    }

    public void updateDish(){
        viewDish();

        System.out.println("Enter dish name to update");
        String oldDishName = Input.getStringInput();

        System.out.println("Enter new Dish Name");
        String newDishName = Input.getStringInput();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Dish> dishList = session.createQuery("from Dish where name = :dishName").setParameter("dishName", oldDishName).list();

        Dish dish = dishList.get(0);
        dish.setName(newDishName);

        session.update(dish);

        session.getTransaction().commit();
        session.close();
    }
}

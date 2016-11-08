package net.therap.mealplannerhibernate.service;

import net.therap.mealplannerhibernate.entity.Dish;
import org.hibernate.Query;
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

    public void addDish(String dish_name){
//        System.out.println("Enter name of dish");
//        String dish_name = Input.getStringInput();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(new Dish(dish_name));
        session.getTransaction().commit();
        session.close();
    }


    public List<Dish> getDish(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Dish> dishList = session.createQuery("FROM Dish").list();

        session.getTransaction().commit();
        session.close();

        //Display.displayDish(dishList);
        return dishList;
    }

    public void updateDish(String newDishName, String oldDishName){
        //getDish();

//        System.out.println("Enter dish name to update");
//        String oldDishName = Input.getStringInput();
//
//        System.out.println("Enter new Dish Name");
//        String newDishName = Input.getStringInput();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        List<Dish> dishList = session.createQuery("from Dish where name = :dishName").setParameter("dishName", oldDishName).list();

        Dish dish = dishList.get(0);
        dish.setName(newDishName);

        session.update(dish);

        session.getTransaction().commit();
        session.close();
    }

    public void deleteDish(int dishId){

        System.out.println(dishId);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("delete from Dish where id = :dishId");
        query.setParameter("dishId", dishId);
        query.executeUpdate();

//
//        Dish dish = new Dish();
//        dish.setId(dishId);
//        session.delete(dish);

        session.getTransaction().commit();
        session.close();

    }
}

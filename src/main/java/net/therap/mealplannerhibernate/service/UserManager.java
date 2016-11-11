package net.therap.mealplannerhibernate.service;

import net.therap.mealplannerhibernate.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

/**
 * @author rayed
 * @since 10/25/16 4:57 PM
 */

public class UserManager {

    private SessionFactory sessionFactory;

    public UserManager(){
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    public boolean addUser(String inputEmail, String inputPassword){
        User user = new User(inputEmail, inputPassword);

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        try {
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e){
            return false;
        } finally {
            session.close();
        }

        return true;
    }

    public User getUser(String inputEmail, String inputPassword) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from User where email = :email and password = :password");
        query.setParameter("email", inputEmail);
        query.setParameter("password", inputPassword);

        List<User> userList = query.list();

        session.getTransaction().commit();
        session.close();

        if (userList.size() == 0){
            return null;
        }
        return userList.get(0);
    }

    public List<User> getUserList(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("from User");
        List<User> userList = query.list();

        session.getTransaction().commit();
        session.close();
        return userList;
    }

    public void deleteUser(int userId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createQuery("delete from User where id = :userId");
        query.setParameter("userId", userId);
        query.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }
}

package net.therap.mealplannerspring.dao;

import net.therap.mealplannerspring.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author rayed
 * @since 11/17/16 11:00 AM
 */

@Repository
@Transactional
public class UserDaoImpl {

    @PersistenceContext
    private EntityManager entityManger;

    public List<User> getUserList() {
        List<User> resultList = (List<User>) entityManger.createQuery("from User").getResultList();
        System.out.println(resultList);
        return resultList;
    }

}

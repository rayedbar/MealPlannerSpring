package net.therap.mealplannerspring.service;

import net.therap.mealplannerspring.dao.UserDao;
import net.therap.mealplannerspring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author rayed
 * @since 11/17/16 11:00 AM
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getUserList() {
        return userDao.findAll();
    }

    public void delete(int userId) {
        userDao.delete(userId);
    }

    public User getUserByEmailAndPassword(String email, String password){
        return userDao.findByEmailAndPassword(email, password);
    }
}

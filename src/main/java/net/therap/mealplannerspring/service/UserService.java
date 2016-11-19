package net.therap.mealplannerspring.service;

import net.therap.mealplannerspring.dao.UserRepository;
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
    private UserRepository userRepository;

    public List<User> getUserList() {
        return userRepository.findAll();
    }

    public void delete(int userId) {
        userRepository.delete(userId);
    }
}

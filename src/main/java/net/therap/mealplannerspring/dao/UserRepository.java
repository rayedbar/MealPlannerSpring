package net.therap.mealplannerspring.dao;

import net.therap.mealplannerspring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Rayed on 18-Nov-16.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}

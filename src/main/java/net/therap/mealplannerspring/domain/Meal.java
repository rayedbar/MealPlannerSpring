package net.therap.mealplannerspring.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author rayed
 * @since 10/17/16 3:26 PM
 */

@Entity
@Table(name = "meal")
public class Meal implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "meal_id")
    private int id;

    @Column(name = "meal_day")
    private String day;

    @Column(name = "meal_type")
    private String type;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "meal_has_dish",
            joinColumns = {@JoinColumn(name = "meal_id")},
            inverseJoinColumns = {@JoinColumn(name = "dish_id")}
    )
    private List<Dish> dishList;

    public Meal() {
    }

    public Meal(String day, String type, List<Dish> dishList) {
        this.day = day;
        this.type = type;
        this.dishList = dishList;
    }

    public Meal(int id, String day, String type, List<Dish> dishList) {
        this.id = id;
        this.day = day;
        this.type = type;
        this.dishList = dishList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Meal)) return false;
//
//        Meal meal = (Meal) o;
//
//        if (id != meal.id) return false;
//        if (!day.equals(meal.day)) return false;
//        if (dishList != null ? !dishList.equals(meal.dishList) : meal.dishList != null) return false;
//        if (!type.equals(meal.type)) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + day.hashCode();
//        result = 31 * result + type.hashCode();
//        result = 31 * result + (dishList != null ? dishList.hashCode() : 0);
//        return result;
//    }
}

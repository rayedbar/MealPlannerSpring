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

}

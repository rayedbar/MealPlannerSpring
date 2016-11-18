package net.therap.mealplannerspring.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author rayed
 * @since 10/17/16 7:09 PM
 */

@Entity
@Table(name = "dish")
public class Dish implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "dish_id")
    private Integer id;

    @Column(name = "dish_name", nullable = false)
    private String name;

    public Dish() {

    }

    public Dish(String name) {
        this.name = name;
    }

    public Dish(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (id != null ? !id.equals(dish.id) : dish.id != null) return false;
        if (name != null ? !name.equals(dish.name) : dish.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }


}

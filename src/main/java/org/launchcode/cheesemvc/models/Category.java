package org.launchcode.cheesemvc.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 15, message = "Field cannot be left blank and must be between 3 and 15 characters.")
    private String name;

    public Category(String name) {
        this();
        this.name = name;
    }

    public Category() {
    }

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Cheese> cheeses = new ArrayList<>();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }


}

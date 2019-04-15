package org.launchcode.cheesemvc.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Menu {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 15, message = "Must be between 3 and 15 characters.")
    private String name;

    @ManyToMany
    private List<Cheese> cheeses = new ArrayList<>();

    public Menu(String name) {
        this.name = name;
    }

    public Menu() { }

    public void addItem(Cheese item) { cheeses.add(item); }

    //public Menu (String name) {this.name = name; }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Cheese> getCheeses() {
        return cheeses;
    }

}

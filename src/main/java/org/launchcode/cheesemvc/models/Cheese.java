package org.launchcode.cheesemvc.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cheese {

    @Id
    @GeneratedValue
    private int id;


    @NotNull
    @Size(min=3, max=15, message = "Name field must be between 3 and 15 characters.") //length of cheese name specified for validation
    private String name;

    @NotNull
    @Size(min=3, max=25, message = "Description field must be between 3 and 25 characters.")
    private String description;

    //private CheeseType type;
    @ManyToOne
    private Category category;
    private CheeseType type;

    public Cheese(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public Cheese() {}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CheeseType getType() {
        return type;
    }

    public void setType(CheeseType type) {
        this.type = type;
   }

    public void setCategory(Category cat) {

    }

   // public String getCheeseId() {
       // return null;
    }
//}
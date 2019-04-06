package org.launchcode.cheesemvc.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Cheese {
    //private int id;
    @NotNull
    @Size(min=3, max=15, message = "Name field must be between 3 and 15 characters.") //length of cheese name specified for validation
    private String name;

    @NotNull
    @Size(min=3, max=25, message = "Description field must be between 3 and 25 characters.")
    private String description;

    private CheeseType type;

    private int cheeseId;
    //private static int nextId = 0;
    private static int nextId = 1;

    public Cheese(String name, String description) {
        //this.id = nextId;
        this(); //call the default constructor for the given class
        this.name = name;
        this.description = description;
        //nextId++;
    }

    public Cheese() {
        cheeseId = nextId;
        nextId++;
    }

    public int getCheeseId() {
        return cheeseId;
    }

    public void setCheeseId(int cheeseId) {
        this.cheeseId = cheeseId;
    }

    //public int getId() {
      //  return id;
    //}

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
}
package com.example.assignment1;

import java.util.List;

public class Tableinfo {
    private String Goals;
    private String Types;
    private List<food> food;

    Tableinfo(String Goals, String Types, List<food> food){
        this.Goals = Goals;
        this.Types = Types;
        this.food = food;
    }
    public String getGoals(){
        return Goals;
    }
    public String getTypes(){
        return Types;
    }

    public List<food> getFood(){
        return food;
    }
}

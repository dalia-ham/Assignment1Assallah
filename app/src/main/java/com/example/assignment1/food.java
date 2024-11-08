package com.example.assignment1;

import java.util.List;

public class food {
    private String info;
    private List<String> mealNames;

    food(String mealType,List<String> mealNames){
        this.info = mealType;
        this.mealNames = mealNames;
    }

    public List<String> getMealNames() {
        return mealNames;
    }
    public String getMealType() {
        return info;
    }
    public String getMealName() {
        return mealNames.isEmpty() ? "" : mealNames.get(0);
    }
}

package com.thelootbasketball.models;

import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("name")
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name + " \n";
    }
}


package com.thelootbasketball.models;

import com.google.gson.annotations.SerializedName;

public class Teams {

    @SerializedName("name")
    private String name;
    @SerializedName("_id")
    private String id;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    @Override
    public String toString(){
        return name + " \n";
    }

}

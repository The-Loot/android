package com.thelootbasketball.models;

import com.google.gson.annotations.SerializedName;

public class Teams {

    @SerializedName("name")
    private String name;
    @SerializedName("_id")
    private String id;
    @SerializedName("division")
    private String division;


    public Teams(){}

    public Teams(String team_Name,String division){
        name = team_Name;
        this.division = division;
    }

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

    public String getDivision(){
        return division;
    }

    public void setDivision(String division){
        this.division = division;
    }



    @Override
    public String toString(){
        return name + " \n";
    }

}

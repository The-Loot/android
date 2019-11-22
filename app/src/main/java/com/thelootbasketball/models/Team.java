package com.thelootbasketball.models;

import com.google.gson.annotations.SerializedName;

public class Team {

    @SerializedName("name")
    private String name;
    @SerializedName("_id")
    private String id;
    @SerializedName("division")
    private String division;


    public Team(){}

    public Team(String team_Name, String team_Id, String division){
        name = team_Name;
        this.id = team_Id;
        this.division = division;
    }

    public String getTeamName(){
        return name;
    }

    public void setTeamName(String name){
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
        return name + " \n" + id + " \n";
    }


}

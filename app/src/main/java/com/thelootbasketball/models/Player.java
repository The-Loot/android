package com.thelootbasketball.models;

import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("_id")
    private  String id;

    @SerializedName("team_id")
    private String team_id;

    @SerializedName("name")
    private String name;

    public String getId(){
        return id;
    }

    public void setId(String id){ this.id = id;}

    public String getTeam_id(){
        return team_id;
    }

    public void setTeam_id(String team_id) {this.team_id = team_id;}

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
<<<<<<< HEAD
        return name + "\n";
=======
        return name + " \n";
>>>>>>> development
    }
}


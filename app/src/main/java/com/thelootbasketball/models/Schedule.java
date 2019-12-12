package com.thelootbasketball.models;

import com.google.gson.annotations.SerializedName;

public class Schedule {

    @SerializedName("teamOne_name")
    private String teamOne_name;

    @SerializedName("teamTwo_name")
    private String teamTwo_name;

    @SerializedName("location")
    private String location;

    @SerializedName("date")
    private String date;

    @SerializedName("division")
    private String division;

    public Schedule(){}

    public Schedule(String teamOne_name, String teamTwo_name, String location, String date, String division){
        this.teamOne_name = teamOne_name;
        this.teamTwo_name = teamTwo_name;
        this.location = location;
        this.date = date;
        this.division = division;
    }

    public String getTeamOne_name(){
        return teamOne_name;
    }

    public void setTeamOne_name(String teamOne_name) {
        this.teamOne_name = teamOne_name;
    }

    public String getTeamTwo_name() {
        return teamTwo_name;
    }

    public void setTeamTwo_name(String teamTwo_name) {
        this.teamTwo_name = teamTwo_name;
    }

    public String getLocation(){
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}

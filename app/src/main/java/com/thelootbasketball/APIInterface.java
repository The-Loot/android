package com.thelootbasketball;

import com.thelootbasketball.models.Player;
import com.thelootbasketball.models.Team;
import com.thelootbasketball.models.Schedule;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {
    @GET("/api/players/team/{id}")
    Call <List<Player>> getPlayersByTeam(@Path("id") String postId);

    @GET("/api/teams")
    Call <List<Team>> getTeam();

    @GET("/api/schedule")
    Call <List<Schedule>> getSchedule();

}

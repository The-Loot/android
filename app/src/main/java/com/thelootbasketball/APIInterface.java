package com.thelootbasketball;

import com.thelootbasketball.models.Player;
import com.thelootbasketball.models.Teams;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("/api/player")
    Call <List<Player>> getPlayers();

    @GET("/api/teams")
    Call <List<Teams>> getTeams();
}

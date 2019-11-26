package com.thelootbasketball;

import com.thelootbasketball.models.Player;
import com.thelootbasketball.models.Team;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface APIInterface {
    @GET("/api/players/{id}")
    Call <List<Player>> getPlayersByTeam(@Path("id") String postId);

    @GET("/api/teams")
    Call <List<Team>> getTeam();

//    @GET
//    Call <List<Player>> getPlayersByTeam(@Url String url);
}

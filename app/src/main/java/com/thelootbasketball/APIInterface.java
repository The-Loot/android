package com.thelootbasketball;

import com.thelootbasketball.models.Player;
import com.thelootbasketball.models.Team;
import com.thelootbasketball.models.Schedule;
import com.thelootbasketball.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.POST;

public interface APIInterface {
    @GET("/api/players/team/{id}")
    Call <List<Player>> getPlayersByTeam(@Path("id") String postId);

    @GET("/api/teams")
    Call <List<Team>> getTeam();

    @GET("/api/schedule")
    Call <List<Schedule>> getSchedule();

    @FormUrlEncoded
    @POST("/api/signup")
    Call<User> createUser(@Field("username") String username,
                          @Field("password") String password);

    @FormUrlEncoded
    @POST("/api/login")
    Call<User> UserLogin(@Field("username") String username,
                         @Field("password") String password);

}

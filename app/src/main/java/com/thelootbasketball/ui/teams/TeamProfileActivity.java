package com.thelootbasketball.ui.teams;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.thelootbasketball.APIClient;
import com.thelootbasketball.APIInterface;
import com.thelootbasketball.models.Team;
import com.thelootbasketball.R;
import com.thelootbasketball.models.Player;
import com.thelootbasketball.models.TeamInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class TeamProfileActivity extends FragmentActivity {
    APIInterface apiInterface;

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_profile_activity);

        final TextView team_name = findViewById(R.id.team_name);
        final TextView textView2 = findViewById(R.id.textView2);

        Toolbar mToolBar = (Toolbar) findViewById(R.id.back_button);
        mToolBar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolBar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });

        TeamInfo t = TeamInfo.getInstance();

        if(getIntent().getExtras() != null){
            Bundle bundle = getIntent().getExtras();
            String teamName = bundle.getString("teamName");
            Team theTeam = t.getTeam(teamName);
            final String team_id = theTeam.getId(); //get the team id value
            if(teamName != null){
                team_name.setText(teamName);
            }

            apiInterface = APIClient.getClient().create(APIInterface.class);
            Call<List<Player>> call = apiInterface.getPlayersByTeam(team_id);
            call.enqueue(new Callback<List<Player>>() {
                @Override
                public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {
                    if(!response.isSuccessful()){
                        textView2.setText("Code: " + response.code());
                        return;
                    }
                    List<Player> getPlayersByTeam = response.body();
                    String displayResponse = "";
                    for(int i = 0; i < getPlayersByTeam.size(); i++){
                        displayResponse += getPlayersByTeam.get(i).toString();
                    }
                    textView2.setTextSize(20);
                    textView2.setText(displayResponse);
                }

                @Override
                public void onFailure(Call<List<Player>> call, Throwable t) {
                    call.cancel();
                }
            });
        } //end if statement
    } //end onCreate()
}

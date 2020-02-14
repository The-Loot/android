package com.thelootbasketball.ui.admin;

import androidx.appcompat.app.AppCompatActivity;

import com.thelootbasketball.APIClient;
import com.thelootbasketball.APIInterface;
import com.thelootbasketball.R;
import com.thelootbasketball.models.Team;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminTeam extends AppCompatActivity {

    APIInterface apiInterface;
    TextView createTeam;
    Button AddTeam;
    EditText CreateTeam_Name, CreateTeam_Division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_team);

        createTeam = findViewById(R.id.CreateTeam);

        CreateTeam_Name = findViewById(R.id.CreateTeam_Name);
        CreateTeam_Division = findViewById(R.id.CreateTeam_Division);
        AddTeam = findViewById(R.id.AddTeam);
        AddTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateTeam();
                CreateTeam_Name.getText().clear();
                CreateTeam_Division.getText().clear();
            }
        });
    }

    private void CreateTeam(){
        String team_name = CreateTeam_Name.getText().toString();
        String team_division = CreateTeam_Division.getText().toString();

        apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Team> call = apiInterface.CreateTeam(team_name, team_division);
        call.enqueue(new Callback<Team>() {
            @Override
            public void onResponse(Call<Team> call, Response<Team> response) {
                if(response.isSuccessful()){
                    Toast.makeText(AdminTeam.this, "Team Created", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(AdminTeam.this, "Fail to Create Team", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Team> call, Throwable t) {
                call.cancel();
            }
        });
    }

}

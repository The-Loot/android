package com.thelootbasketball.ui.admin;

import androidx.appcompat.app.AppCompatActivity;

import com.thelootbasketball.APIClient;
import com.thelootbasketball.APIInterface;
import com.thelootbasketball.R;
import com.thelootbasketball.models.Team;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminTeam extends AppCompatActivity  {

    APIInterface apiInterface;
    TextView createTeam;
    Button AddTeam, UpdateTeam, DeleteTeam;
    EditText CreateTeam_Name, CreateTeam_Division, UpdateTeam_Name, UpdateTeam_Division,
            DeleteTeam_Name, DeleteTeam_Division;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_team);

        createTeam = findViewById(R.id.TeamText);

//        spinner = findViewById(R.id.TeamOptions);
//        spinner.setOnItemSelectedListener(this);
//        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.team_array, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
//
//            CreateTeam_Name = findViewById(R.id.CreateTeam_Name);
//            CreateTeam_Division = findViewById(R.id.CreateTeam_Division);
//            AddTeam = findViewById(R.id.AddTeam);
//            AddTeam.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    CreateTeam();
//                    CreateTeam_Name.getText().clear();
//                    CreateTeam_Division.getText().clear();
//                }
//            });
//
//        UpdateTeam_Name = findViewById(R.id.UpdateTeam_Name);
//        UpdateTeam_Division = findViewById(R.id.UpdateTeam_Division);
//        UpdateTeam = findViewById(R.id.UpdateTeam);
//        UpdateTeam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                UpdateTeam();
//                UpdateTeam_Name.getText().clear();
//                UpdateTeam_Division.getText().clear();
//            }
//        });
//
//        DeleteTeam = findViewById(R.id.DeleteTeam);
//        DeleteTeam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                DeleteUser();
//            }
//        });
    }

//    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
//        String item = parent.getItemAtPosition(pos).toString();
//
//        if(item.contentEquals("Create Team")){
//
//
//        }
//        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
//    }
//
//   public void onNothingSelected(AdapterView<?> arg0){
//            //do nothing
//   }
//
//    private void CreateTeam(){
//        String team_name = CreateTeam_Name.getText().toString();
//        String team_division = CreateTeam_Division.getText().toString();
//
//        apiInterface = APIClient.getClient().create(APIInterface.class);
//        Call<Team> call = apiInterface.CreateTeam(team_name, team_division);
//        call.enqueue(new Callback<Team>() {
//            @Override
//            public void onResponse(Call<Team> call, Response<Team> response) {
//                if(response.isSuccessful()){
//                    Toast.makeText(AdminTeam.this, "Team Created", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(AdminTeam.this, "Failed to Create Team", Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onFailure(Call<Team> call, Throwable t) {
//                call.cancel();
//            }
//        });
//    }
//
//    private void UpdateTeam(){
//        String id = "5da64c6d7c9159a2aff2ca19";
//        String team_name = UpdateTeam_Name.getText().toString();
//        String team_division = UpdateTeam_Division.getText().toString();
//
//        apiInterface = APIClient.getClient().create(APIInterface.class);
//        Call<Team> call = apiInterface.UpdateTeam(id, team_name, team_division);
//        call.enqueue(new Callback<Team>() {
//            @Override
//            public void onResponse(Call<Team> call, Response<Team> response) {
//                if(response.isSuccessful()){
//                    Toast.makeText(AdminTeam.this, "Team Updated", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(AdminTeam.this, "Failed to Update", Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onFailure(Call<Team> call, Throwable t) {
//                call.cancel();
//            }
//        });
//    }
//
//    private void DeleteUser(){
//        String id = "5dace6ffa1e03e3d9af66668";
//
//        apiInterface = APIClient.getClient().create(APIInterface.class);
//        Call<Team> call = apiInterface.DeleteTeam(id);
//        call.enqueue(new Callback<Team>() {
//            @Override
//            public void onResponse(Call<Team> call, Response<Team> response) {
//                if(response.isSuccessful()){
//                    Toast.makeText(AdminTeam.this, "Team been Deleted", Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(AdminTeam.this, "Failed to Delete team", Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onFailure(Call<Team> call, Throwable t) {
//                call.cancel();
//            }
//        });
//
//
//    }

}

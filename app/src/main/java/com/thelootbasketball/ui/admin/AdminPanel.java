package com.thelootbasketball.ui.admin;

import androidx.appcompat.app.AppCompatActivity;

import com.thelootbasketball.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class AdminPanel extends AppCompatActivity {

    TextView createTeam, createPlayer, createSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        createTeam = findViewById(R.id.Admin_Team);

        createTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent team = new Intent(getApplication(), AdminTeam.class);
                startActivity(team);
            }
        });
    }

}

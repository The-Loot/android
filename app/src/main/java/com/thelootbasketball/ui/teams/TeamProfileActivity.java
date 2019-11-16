package com.thelootbasketball.ui.teams;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.thelootbasketball.R;

public class TeamProfileActivity extends FragmentActivity {
    Toolbar mToolBar;


    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_profile_activity);

        final TextView textView = findViewById(R.id.textView1);

        textView.setText("Team Name");
        mToolBar = (Toolbar) findViewById(R.id.toolbar);

    }


}

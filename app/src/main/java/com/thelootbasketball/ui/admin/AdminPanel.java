package com.thelootbasketball.ui.admin;

import androidx.appcompat.app.AppCompatActivity;
import com.thelootbasketball.R;
import android.os.Bundle;
import android.widget.TextView;

public class AdminPanel extends AppCompatActivity {

    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);
        test = findViewById(R.id.test);
    }
}

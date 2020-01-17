package com.thelootbasketball.ui.admin;

import androidx.appcompat.app.AppCompatActivity;

import com.thelootbasketball.R;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;


public class AdminLogin extends AppCompatActivity {

    EditText UserNameInputField, PasswordInputField;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        UserNameInputField = findViewById(R.id.usernameTextEdit);
        PasswordInputField = findViewById(R.id.passwordTextEdit);
        loginButton = findViewById(R.id.LoginButton);
    }
}

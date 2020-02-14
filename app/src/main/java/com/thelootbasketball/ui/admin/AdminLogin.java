package com.thelootbasketball.ui.admin;

import androidx.appcompat.app.AppCompatActivity;

import com.thelootbasketball.APIClient;
import com.thelootbasketball.APIInterface;
import com.thelootbasketball.R;
import com.thelootbasketball.models.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AdminLogin extends AppCompatActivity {

    APIInterface apiInterface;
    EditText UserNameInputField, PasswordInputField;
    Button loginButton;
    TextView Registration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        UserNameInputField = findViewById(R.id.usernameTextEdit);
        PasswordInputField = findViewById(R.id.passwordTextEdit);
        loginButton = findViewById(R.id.LoginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        Registration = findViewById(R.id.register_text);
        Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registration = new Intent(getApplication(), AdminSignUp.class);
                startActivity(registration);
            }
        });
    }

        public void login(){
            if (validate() == false){
                return;
            }
            loginByServer();
        }

        private void loginByServer(){
            String username = UserNameInputField.getText().toString();
            String password = PasswordInputField.getText().toString();

            apiInterface = APIClient.getClient().create(APIInterface.class);
            Call<User> call = apiInterface.UserLogin(username, password);
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if(response.isSuccessful()){
                        startActivity(new Intent(AdminLogin.this, AdminPanel.class));
                        finish();
                    }
                    else {
                        Toast.makeText(AdminLogin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    call.cancel();
                }
            });
        }

    public boolean validate() {
        boolean valid = true;

        String username = UserNameInputField.getText().toString();
        String password = PasswordInputField.getText().toString();

        if (username.isEmpty()){
            UserNameInputField.setError("Name should not be empty");
            valid = false;
        } else{
            UserNameInputField.setError(null);
        }

        if (password.isEmpty()){
            PasswordInputField.setError("Please enter a password");
            valid = false;
        } else {
            PasswordInputField.setError(null);
        }
        return valid;
    }


}

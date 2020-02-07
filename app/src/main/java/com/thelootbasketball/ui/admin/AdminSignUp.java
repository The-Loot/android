package com.thelootbasketball.ui.admin;

import androidx.appcompat.app.AppCompatActivity;

import com.thelootbasketball.APIClient;
import com.thelootbasketball.APIInterface;
import com.thelootbasketball.R;
import com.thelootbasketball.models.User;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class AdminSignUp extends AppCompatActivity {
    APIInterface apiInterface;
    EditText UserNameNew, PasswordNew;
    Button register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_sign_up);

        UserNameNew = findViewById(R.id.UserNameNew);
        PasswordNew = findViewById(R.id.PasswordNew);
        register = findViewById(R.id.Register_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup();
            }
        });
    }

        public void signup() {
            if (validate() == false){
                return;
            }
            saveToServerDB();
        }

        public boolean validate() {
            boolean valid = true;

            String username = UserNameNew.getText().toString();
            String password = PasswordNew.getText().toString();

            if (username.isEmpty()){
                UserNameNew.setError("Name should not be empty");
                valid = false;
            } else{
                UserNameNew.setError(null);
            }

            if (password.isEmpty()){
                PasswordNew.setError("Please enter a password");
                valid = false;
            } else {
                PasswordNew.setError(null);
            }
            return valid;
        }

        private void saveToServerDB(){
            String username = UserNameNew.getText().toString();
            String password = PasswordNew.getText().toString();

            apiInterface = APIClient.getClient().create(APIInterface.class);
            Call<User> call = apiInterface.createUser(username, password);
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if(response.isSuccessful()){
                        startActivity(new Intent(AdminSignUp.this, AdminPanel.class));
                        finish();
                    }
                    else {
                        Toast.makeText(AdminSignUp.this, "Sign Up Failed", Toast.LENGTH_SHORT);
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    call.cancel();
                }
            });


        }
}

package com.example.logsignsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.logsignsql.databinding.ActivityLogin123Binding;

public class LoginActivity123 extends AppCompatActivity {

    ActivityLogin123Binding binding;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login123);


        databaseHelper = new DatabaseHelper(this);
        binding.loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.loginEmail.getText().toString();
                String password = binding.loginPassword.getText().toString();

                if (email.equals("") || password.equals("")) {
                    Toast.makeText(LoginActivity123.this, "All field are mandatory", Toast.LENGTH_SHORT).show();

                }else{
                        Boolean checkCredentials = databaseHelper.checkEmailPassword(email, password);

                        if (checkCredentials == true) {
                            Toast.makeText(LoginActivity123.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(LoginActivity123.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();

                        }
                    }
                }

        });
        binding.signupRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity123.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}

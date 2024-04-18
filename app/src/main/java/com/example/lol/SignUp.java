package com.example.lol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class SignUp extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.sign_up);

            Button signUpButton = findViewById(R.id.button5);
            signUpButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Здесь может быть ваша логика обработки данных формы
                    Toast.makeText(SignUp.this, "Sign Up button clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
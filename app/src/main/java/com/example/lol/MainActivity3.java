package com.example.lol;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button nextButton = findViewById(R.id.button2);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, SignUp.class);
                startActivity(intent);
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Здесь может быть ваша логика обработки данных формы
                Toast.makeText(MainActivity3.this, "Button clicked", Toast.LENGTH_SHORT).show();
                // Открытие activity_log_in.xml
                Intent intent = new Intent(MainActivity3.this, LogIn.class);
                startActivity(intent);
            }
        });
    }
}

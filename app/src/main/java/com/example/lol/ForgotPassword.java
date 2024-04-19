package com.example.lol;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPassword extends AppCompatActivity {

    private EditText editTextEmail;
    private Button buttonLogIn, buttonBackToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        editTextEmail = findViewById(R.id.editText3);
        buttonLogIn = findViewById(R.id.buttonLogIn);
        buttonBackToLogin = findViewById(R.id.button);

        // Установка слушателя для изменения цвета кнопки в зависимости от заполненности поля
        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(s)) {
                    buttonLogIn.setBackgroundTintList(ColorStateList.valueOf(Color.GRAY));
                } else {
                    buttonLogIn.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
                }
            }
        });

        // Нажатие на кнопку "Send OTP"
        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editTextEmail.getText())) {
                    Toast.makeText(ForgotPassword.this, "Please enter your email address", Toast.LENGTH_SHORT).show();
                } else {
                    // Переход к активности OTP Verification
                    Intent intent = new Intent(ForgotPassword.this, OTPVerification.class);
                    startActivity(intent);
                }
            }
        });

        // Нажатие на кнопку "Sign In"
        buttonBackToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Переход к активности Login
                Intent intent = new Intent(ForgotPassword.this, LogIn.class);
                startActivity(intent);
            }
        });
    }
}

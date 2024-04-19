package com.example.lol;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LogIn extends AppCompatActivity {

    private CheckBox checkBox;
    private EditText editText3, editText4;
    private Button logInButton, forgotPasswordButton, signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // Инициализация элементов интерфейса
        checkBox = findViewById(R.id.checkBox2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        logInButton = findViewById(R.id.buttonLogIn);
        forgotPasswordButton = findViewById(R.id.button3);
        signUpButton = findViewById(R.id.button);

        // Добавление слушателей для полей ввода
        editText3.addTextChangedListener(textWatcher);
        editText4.addTextChangedListener(textWatcher);

        // Добавление слушателя для CheckBox
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkFieldsAndButtonState();
            }
        });

        // Добавление слушателя для кнопки
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (logInButton.isEnabled()) {
                    Toast.makeText(LogIn.this, "Sign Up button clicked", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LogIn.this, Home.class);
                    startActivity(intent);
                }
            }
        });

        // Добавление слушателей для кнопок восстановления пароля и регистрации
        forgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, ForgotPassword.class);
                startActivity(intent);
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogIn.this, SignUp.class);
                startActivity(intent);
            }
        });
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            checkFieldsAndButtonState();
        }
    };

    private void checkFieldsAndButtonState() {
        boolean allFieldsFilled =
                !editText3.getText().toString().isEmpty() &&
                        !editText4.getText().toString().isEmpty();

        boolean checkBoxChecked = checkBox.isChecked();

        if (allFieldsFilled && checkBoxChecked) {
            logInButton.setEnabled(true);
            logInButton.setBackgroundColor(Color.BLUE); // Изменение цвета кнопки на синий
        } else {
            logInButton.setEnabled(false);
            logInButton.setBackgroundColor(Color.GRAY); // Изменение цвета кнопки на серый
        }
    }
}

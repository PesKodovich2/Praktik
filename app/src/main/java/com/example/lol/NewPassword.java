package com.example.lol;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.Editable;
import android.text.TextWatcher;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;

public class NewPassword extends AppCompatActivity {

    private EditText editText1, editText2;
    private Button buttonLogIn;
    private TextView textViewError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        buttonLogIn = findViewById(R.id.buttonLogIn);
        textViewError = findViewById(R.id.textViewError); // Предполагается, что у вас есть TextView для отображения ошибок

        // Отключение кнопки по умолчанию
        buttonLogIn.setEnabled(false);

        // Добавление TextWatcher к обеим EditText
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String password1 = editText1.getText().toString().trim();
                String password2 = editText2.getText().toString().trim();

                // Включение кнопки, если оба поля не пусты и содержат одинаковый текст
                buttonLogIn.setEnabled(!TextUtils.isEmpty(password1) && !TextUtils.isEmpty(password2) && password1.equals(password2));

                // Изменение цвета кнопки на синий, если в оба поля введен текст
                if (!TextUtils.isEmpty(password1) && !TextUtils.isEmpty(password2)) {
                    buttonLogIn.setBackgroundColor(Color.parseColor("#0000FF"));
                } else {
                    buttonLogIn.setBackgroundColor(Color.parseColor("#808080")); // Вернуть исходный цвет, если в одно из полей не введен текст
                }

                // Проверка совпадения текстов и обновление ошибки
                if (!password1.equals(password2)) {
                    textViewError.setText("Passwords are different");
                    textViewError.setVisibility(View.VISIBLE);
                } else {
                    textViewError.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        editText1.addTextChangedListener(textWatcher);
        editText2.addTextChangedListener(textWatcher);

        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password1 = editText1.getText().toString().trim();
                String password2 = editText2.getText().toString().trim();

                if (!password1.equals(password2)) {
                    textViewError.setText("Passwords are different");
                    textViewError.setVisibility(View.VISIBLE);
                } else {
                    textViewError.setVisibility(View.GONE);
                    // Переход на страницу activity_log_in.xml
                    Intent intent = new Intent(NewPassword.this, LogIn.class);
                    startActivity(intent);
                }
            }
        });
    }
}
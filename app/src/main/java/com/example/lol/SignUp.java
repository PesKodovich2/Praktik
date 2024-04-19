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

public class SignUp extends AppCompatActivity {

    private CheckBox checkBox;
    private EditText editText1, editText2, editText3, editText4, editText5;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        // Инициализация элементов интерфейса
        checkBox = findViewById(R.id.checkBox);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        signUpButton = findViewById(R.id.button5);

        // Добавление слушателей для полей ввода
        editText1.addTextChangedListener(textWatcher);
        editText2.addTextChangedListener(textWatcher);
        editText3.addTextChangedListener(textWatcher);
        editText4.addTextChangedListener(textWatcher);
        editText5.addTextChangedListener(textWatcher);

        // Добавление слушателя для CheckBox
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkFieldsAndButtonState();
            }
        });

        // Добавление слушателя для кнопки
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (signUpButton.isEnabled()) {
                    // Здесь может быть ваша логика обработки данных формы
                    Toast.makeText(SignUp.this, "Sign Up button clicked", Toast.LENGTH_SHORT).show();
                    // Открытие LogIn.class
                    Intent intent = new Intent(SignUp.this, LogIn.class);
                    startActivity(intent);
                }
            }
        });

        // Добавление слушателя для кнопки с идентификатором button
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Здесь может быть ваша логика обработки данных формы
                Toast.makeText(SignUp.this, "Button clicked", Toast.LENGTH_SHORT).show();
                // Открытие activity_log_in.xml
                Intent intent = new Intent(SignUp.this, LogIn.class);
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
        boolean allFieldsFilled = !editText1.getText().toString().isEmpty() &&
                !editText2.getText().toString().isEmpty() &&
                !editText3.getText().toString().isEmpty() &&
                !editText4.getText().toString().isEmpty() &&
                !editText5.getText().toString().isEmpty();

        boolean checkBoxChecked = checkBox.isChecked();

        if (allFieldsFilled && checkBoxChecked) {
            signUpButton.setEnabled(true);
            signUpButton.setBackgroundColor(Color.BLUE); // Изменение цвета кнопки на синий
        } else {
            signUpButton.setEnabled(false);
            signUpButton.setBackgroundColor(Color.GRAY); // Изменение цвета кнопки на серый
        }
    }
}

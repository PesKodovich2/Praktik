package com.example.lol;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class OTPVerification extends AppCompatActivity {

    private EditText[] otpEditTexts = new EditText[6];
    private Button buttonLogIn;
    private TextView textView17;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        // Инициализация EditTexts для OTP
        otpEditTexts[0] = findViewById(R.id.editText1);
        otpEditTexts[1] = findViewById(R.id.editText2);
        otpEditTexts[2] = findViewById(R.id.editText3);
        otpEditTexts[3] = findViewById(R.id.editText4);
        otpEditTexts[4] = findViewById(R.id.editText5);
        otpEditTexts[5] = findViewById(R.id.editText6);

        // Инициализация кнопки и TextView для таймера
        buttonLogIn = findViewById(R.id.buttonLogIn);
        textView17 = findViewById(R.id.textView17);

        // Настройка таймера
        setupTimer();

        // Настройка обработчиков событий для EditTexts и кнопки
        setupEditTexts();
        setupButton();
    }

    private void setupTimer() {
        countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                textView17.setText(String.format("%d:%02d", millisUntilFinished / 60000, (millisUntilFinished % 60000) / 1000));
            }

            @Override
            public void onFinish() {
                textView17.setText("Resent?");
                textView17.setTextColor(Color.parseColor("#0000FF")); // Изменение цвета текста на синий
                textView17.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Переход к экрану отправки OTP
                        Intent intent = new Intent(OTPVerification.this, OTPVerification.class);
                        startActivity(intent);
                    }
                });
            }
        }.start();
    }

    private void setupEditTexts() {
        for (EditText editText : otpEditTexts) {
            editText.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (keyCode == KeyEvent.KEYCODE_DEL) {
                        return false;
                    }
                    return editText.getText().length() < 1;
                }
            });
        }
    }

    private void setupButton() {
        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Проверка, что все поля заполнены
                boolean allFilled = true;
                for (EditText editText : otpEditTexts) {
                    if (editText.getText().length() == 0) {
                        allFilled = false;
                        break;
                    }
                }

                if (allFilled) {
                    // Переход к экрану установки нового пароля
                    Intent intent = new Intent(OTPVerification.this, NewPassword.class);
                    startActivity(intent);
                }
            }
        });

        // Проверка и обновление состояния кнопки при каждом изменении текста в EditText
        for (EditText editText : otpEditTexts) {
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {}

                @Override
                public void afterTextChanged(Editable s) {
                    boolean allFieldsFilled = true;
                    for (EditText editText : otpEditTexts) {
                        if (editText.getText().length() == 0) {
                            allFieldsFilled = false;
                            break;
                        }
                    }

                    if (allFieldsFilled) {
                        buttonLogIn.setEnabled(true);
                        buttonLogIn.setBackgroundColor(Color.BLUE); // Изменение цвета кнопки на синий
                    } else {
                        buttonLogIn.setEnabled(false);
                        buttonLogIn.setBackgroundColor(Color.GRAY); // Изменение цвета кнопки на серый
                    }
                }
            });
        }
    }
}



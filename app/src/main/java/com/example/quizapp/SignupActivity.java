package com.example.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText emailEditText;
    private EditText passwordEditText;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Gerekli bileşenleri arayüzden bağlama
        usernameEditText = findViewById(R.id.signupUsernameEditText);
        emailEditText = findViewById(R.id.signupEmailEditText);
        passwordEditText = findViewById(R.id.signupPasswordEditText);
        signUpButton = findViewById(R.id.signupButton);

        // Kayıt ol butonuna tıklama olayını belirleme
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void signUp() {
        String username = usernameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        // Girilen bilgileri kontrol etme
        if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Lütfen tüm alanları doldurun.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Kayıt işlemini burada gerçekleştirin
        // Örneğin, bir API'ye kayıt isteği göndermek veya veritabanına kaydetmek

        // Başarılı kayıt durumunda kullanıcıyı bildirin
        Toast.makeText(this, "Kayıt başarıyla tamamlandı!", Toast.LENGTH_SHORT).show();

        // İstediğiniz bir eylemi gerçekleştirin, örneğin giriş ekranına yönlendirme yapabilirsiniz
    }
}

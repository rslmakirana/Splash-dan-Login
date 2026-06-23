package com.example.itscollegerlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText etUserID, etUserPass;
    Button btLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        etUserID = findViewById(R.id.et_user_id);
        etUserPass = findViewById(R.id.et_user_pass);
        btLogin = findViewById(R.id.bt_login);

        btLogin.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View view) {
        String userLogin = etUserID.getText().toString().trim();
        String passLogin = etUserPass.getText().toString().trim();

        if (userLogin.isEmpty()) {
            etUserID.setError("User Tidak Boleh Kosong!");
        }

        if (passLogin.isEmpty()) {
            etUserPass.setError("Password Tidak Boleh Kosong!");
        } else {
            if (userLogin.equals("admin") && passLogin.equals("admin")) {
                Intent intentMain = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intentMain);
            } else {
                AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
                alert.setMessage("UserID atau Password Anda Salah!")
                        .setNegativeButton("retry", null).create().show();
            }
        }
    }
}
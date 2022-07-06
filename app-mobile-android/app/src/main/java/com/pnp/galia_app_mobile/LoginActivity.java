package com.pnp.galia_app_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText editTextUser;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btn_login);
        editTextUser = findViewById(R.id.editText_user);
        editTextPassword = findViewById(R.id.editText_password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHomepage(view);
            }
        });
    }

    public void openHomepage(View view){
        if(editTextUser.getText().toString().equals("navigator")){
            if(editTextPassword.getText().toString().equals("123456")) {
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
            }
        }
    }
}
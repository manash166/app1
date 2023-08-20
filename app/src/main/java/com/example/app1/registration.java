package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registration extends AppCompatActivity {
Button register_btn;
  EditText mobilenumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_registration);
         mobilenumber=findViewById(R.id.editTextPhone2);
         register_btn=findViewById(R.id.register_btn);
          register_btn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent= new Intent(registration.this, otp_screen.class);
                  intent.putExtra("mobile",mobilenumber.getText().toString().trim());
                  startActivity(intent);

              }
          });
    }
}
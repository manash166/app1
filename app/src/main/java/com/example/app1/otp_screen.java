package com.example.app1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class otp_screen extends AppCompatActivity {
     private String verificationId;
    EditText editTextNumber, editTextNumber2, editTextNumber3, editTextNumber4,editTextNumber5,editTextNumber6;
     Button verify_btn,resend_btn;
    TextView display_mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_screen);
        display_mobile = findViewById(R.id.textView3);
        editTextNumber = findViewById(R.id.editTextNumber);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        editTextNumber3 = findViewById(R.id.editTextNumber3);
        editTextNumber4 = findViewById(R.id.editTextNumber4);
        editTextNumber5 =findViewById(R.id.editTextNumber8);
        editTextNumber6 =findViewById(R.id.editTextNumber9);
       resend_btn=findViewById(R.id.resend_btn);
        Intent mobile_display_intent = getIntent();
        String mobile = mobile_display_intent.getStringExtra("mobile");
       display_mobile.setText(String.format("+91" + mobile));
//        display_mobile.setText(mobile);
        numbermove();
        verificationId = getIntent().getStringExtra("verificationId");
          verify_btn=findViewById(R.id.button2);
          verify_btn.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  if(editTextNumber.getText().toString().trim().isEmpty()
                          ||editTextNumber2.getText().toString().trim().isEmpty()
                          ||editTextNumber3.getText().toString().trim().isEmpty()
                          ||editTextNumber4.getText().toString().trim().isEmpty()
                          ||editTextNumber5.getText().toString().trim().isEmpty()
                          ||editTextNumber6.getText().toString().trim().isEmpty()
                    ){
                      Toast.makeText(otp_screen.this, "Enter Valid Otp", Toast.LENGTH_SHORT).show();
                  } else {
                      if(verificationId!=null){
                          String code=editTextNumber.getText().toString().trim()+
                                  editTextNumber2.getText().toString().trim()+
                                  editTextNumber3.getText().toString().trim()+
                                  editTextNumber4.getText().toString().trim()+
                                  editTextNumber5.getText().toString().trim()+
                                  editTextNumber6.getText().toString().trim();
                          PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
                          FirebaseAuth.getInstance()
                                  .signInWithCredential(credential)
                                  .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                              @Override
                              public void onComplete(@NonNull Task<AuthResult> task) {
                                  if (task.isSuccessful()) {
                                      Intent intent_success = new Intent(otp_screen.this,MainActivity.class);
                                    startActivity(intent_success);
                                  }
                                  else {
                                      Toast.makeText(otp_screen.this, "Enter Correct Otp", Toast.LENGTH_SHORT).show();
                                  }
                              }
                          });

                      }

                  }
              }
          });


           //for resend otp
 resend_btn.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {

     }
 });
    }
           //for focusing next input numbermove() is used below;
    private void numbermove() {
        editTextNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if (!s.toString().trim().isEmpty()) {
                    editTextNumber2.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editTextNumber2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if (!s.toString().trim().isEmpty()) {
                    editTextNumber3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editTextNumber3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if (!s.toString().trim().isEmpty()) {
                    editTextNumber4.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editTextNumber4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if (!s.toString().trim().isEmpty()) {
                    editTextNumber5.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        editTextNumber5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                if (!s.toString().trim().isEmpty()) {
                    editTextNumber6.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

}
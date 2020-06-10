package com.rgbat.communityadmin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import okhttp3.internal.http2.Header;

public class MainActivity extends AppCompatActivity {
    private EditText editTextEmail ,editTextPassword;
    private Button buttonLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextEmail = findViewById(R.id.admin_email);
        editTextPassword = findViewById(R.id.admin_password);
        buttonLogin = findViewById(R.id.admin_login);
        mAuth = FirebaseAuth.getInstance();
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                if (email.isEmpty()) {
                    editTextEmail.setError("Please Enter Your Email");
                    return;
                } else if (password.isEmpty()) {
                    editTextPassword.setError("Please Enter Your Email");
                    return;
                } else {

                    Login(email, password);

                }
            }
        });
        if (mAuth.getCurrentUser() != null){
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {


                    Intent intent = new Intent(getBaseContext(),CategoryActivity.class);
                    startActivity(intent);

                }
            },3000);

        }
    }

    private void Login(String email, String password) {
//


        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(getBaseContext(),"Login Is successful",Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getBaseContext(),CategoryActivity.class);
                            startActivity(intent);


                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getBaseContext(),"Please try Again",Toast.LENGTH_LONG).show();
                            // ...
                        }

                        // ...
                    }
                });







    }




    }




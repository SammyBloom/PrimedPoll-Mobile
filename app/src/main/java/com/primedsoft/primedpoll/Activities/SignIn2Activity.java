package com.primedsoft.primedpoll.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.primedsoft.primedpoll.Data;
import com.primedsoft.primedpoll.R;
import com.primedsoft.primedpoll.SignUp2;
import com.primedsoft.primedpoll.api.ApiInterface;
import com.primedsoft.primedpoll.api.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignIn2Activity extends AppCompatActivity {
    EditText signInEmail, signInPassword;
    String email, password;
    AppCompatButton signInButton;
    TextView signUpText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_sign_in2);
        super.onCreate(savedInstanceState);
        signInEmail = findViewById(R.id.sign_in_email);
        signInPassword = findViewById(R.id.sign_in_password);
        signInButton = findViewById(R.id.sign_in_button);
signUpText = findViewById(R.id.sign_up_text);
signUpText.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(SignIn2Activity.this, SignUp2.class));
    }
});


        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        email = signInEmail.getText().toString().trim();
        password = signInPassword.getText().toString().trim();

        if (loginValidation()) return;

        ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
        Data data = new Data(email, password);
        apiInterface.login(data.getEmail(),
                data.getPassword()).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if(response.code() == 200){
                    Toast.makeText(SignIn2Activity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(SignIn2Activity.this, "Not logged in", Toast.LENGTH_SHORT).show();}
            }
            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                t.getMessage();
                Toast.makeText(SignIn2Activity.this, "Connection Error! Restart Network", Toast.LENGTH_LONG).show();

            }
        });
    }

    private boolean loginValidation() {
        //Validation for email
        if (email.isEmpty()) {
            signInEmail.setError("Email is required");
            signInEmail.requestFocus();
            return true;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signInEmail.setError("Incorrect Email");
            signInEmail.requestFocus();
            return true;
        }

        //Validation for Password
        if (password.isEmpty()) {
            signInPassword.setError("Password is required");
            signInPassword.requestFocus();
            return true;
        }
        return false;
    }
}

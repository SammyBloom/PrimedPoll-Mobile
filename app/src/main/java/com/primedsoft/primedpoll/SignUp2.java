package com.primedsoft.primedpoll;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.primedsoft.primedpoll.Activities.SignIn2Activity;
import com.primedsoft.primedpoll.api.ApiInterface;
import com.primedsoft.primedpoll.api.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp2 extends AppCompatActivity {
    EditText signUpEmail, signUpPassword, signUpConfirmPassword;
    String email, password, confirmPassword;
    AppCompatButton signUpButton;
    TextView signInText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_sign_up2);
        super.onCreate(savedInstanceState);
        signUpEmail = findViewById(R.id.sign_up_email);
        signUpPassword = findViewById(R.id.sign_up_password);
        signUpConfirmPassword = findViewById(R.id.sign_up_confirm_password);
signInText = findViewById(R.id.sign_in_text);

signInText.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      startActivity(new Intent(SignUp2.this, SignIn2Activity.class));
                                  }
                              }
);
        signUpButton = findViewById(R.id.sign_up_button);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();

            }
        });
    }

    private void registerUser() {
        email = signUpEmail.getText().toString().trim();
        password = signUpPassword.getText().toString().trim();
        confirmPassword = signUpConfirmPassword.getText().toString().trim();

        if (registrationValidation()) return;

        ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
        Data data = new Data(email, password, confirmPassword);
        apiInterface.register(data.getEmail(),
                data.getPassword(),
                data.getConfirmPassword()).enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (response.code() == 200) {
                    Toast.makeText(SignUp2.this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
                    final AlertDialog.Builder alertDialog = new AlertDialog.Builder(SignUp2.this);
                    alertDialog.setTitle("You need to verify your account in other to login? Click Ok to proceed.");
                    alertDialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_APP_EMAIL);
                            startActivity(intent);
                            startActivity(Intent.createChooser(intent, "Send FeedBack"));
                            SignUp2.this.finish();
                        }
                    });
                    AlertDialog alertDialogCreate = alertDialog.create();

                    // show it
                    alertDialogCreate.show();
                } else {
                    Toast.makeText(SignUp2.this, "Email Already Taken", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                t.getMessage();
                Toast.makeText(SignUp2.this, "Connection Error! Restart Network", Toast.LENGTH_LONG).show();

            }
        });
    }

    private boolean registrationValidation() {
        //Validation for email
        if (email.isEmpty()) {
            signUpEmail.setError("Email is required");
            signUpEmail.requestFocus();
            return true;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            signUpEmail.setError("Incorrect Email");
            signUpEmail.requestFocus();
            return true;
        }

        //Validation for Password
        if (password.isEmpty()) {
            signUpPassword.setError("Password is required");
            signUpPassword.requestFocus();
            return true;
        }

        //Validation for confirm password
        if (confirmPassword.isEmpty()) {
            signUpConfirmPassword.setError("Password is required");
            signUpConfirmPassword.requestFocus();
            return true;
        }

        if (!confirmPassword.equals(password)) {
            signUpConfirmPassword.setError("Password does not match");
            signUpConfirmPassword.requestFocus();
            return true;
        }
        return false;
    }
}

package com.primedsoft.primedpoll.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.primedsoft.primedpoll.R;

public class SignUp extends AppCompatActivity {

    private EditText signup_email, signup_password, signup_cnfPassword;
    private Button signup_btn;
    private CheckBox tac;
    private ProgressBar signup_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signup_email = (EditText) findViewById(R.id.input_email);
        signup_password = (EditText) findViewById(R.id.input_password);
        signup_cnfPassword = (EditText) findViewById(R.id.input_confirm_password);
        signup_btn = (Button) findViewById(R.id.btn_signup);
        tac = (CheckBox) findViewById(R.id.tac_signup);
        signup_progress = (ProgressBar) findViewById(R.id.signup_progressbar);

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(tac.isChecked()){
                    userSignUp();
                } else {
                    tac.setError("Accept our terms and conditions then proceed");
                    tac.requestFocus();
                }
            }
        });
    }

    public void userSignUp(){

        String email = signup_email.getText().toString().trim();
        String password = signup_password.getText().toString().trim();
        String cnf_password = signup_cnfPassword.getText().toString().trim();

        //Validation for email
        if (email.isEmpty()){
            signup_email.setError("Email is required");
            signup_email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            signup_email.setError("Incorrect Email");
            signup_email.requestFocus();
            return;
        }

        //Validation for Password
        if (password.isEmpty()){
            signup_password.setError("Password is required");
            signup_password.requestFocus();
            return;
        }

        //Validation for confirm password
        if (cnf_password.isEmpty()){
            signup_cnfPassword.setError("Password is required");
            signup_cnfPassword.requestFocus();
            return;
        }

        if (!cnf_password.equals(password)){
            signup_cnfPassword.setError("Password does not match");
            signup_cnfPassword.requestFocus();
            return;
        }
    }
}

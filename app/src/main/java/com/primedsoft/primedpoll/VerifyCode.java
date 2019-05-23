package com.primedsoft.primedpoll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.primedsoft.primedpoll.api.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VerifyCode extends AppCompatActivity {
    Button verification;
    AppCompatEditText verifyCode;
    ProgressBar vProgressbar;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_code);

        Toolbar verifyToolbar = findViewById(R.id.verifycode_toolbar);
        setSupportActionBar(verifyToolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        verification = findViewById(R.id.verify_button);
        verifyCode = findViewById(R.id.code_edit);
        vProgressbar = findViewById(R.id.verify_progressbar);

        token = getIntent().getStringExtra("token");

        verification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificate();
            }
        });

    }

    public void verificate(){

        final String code = verifyCode.getText().toString().trim();

        if (code.isEmpty()){
            verifyCode.setError("Enter verification code here");
            return;
        }

        vProgressbar.setVisibility(View.VISIBLE);

        Call<Data> call = RetrofitClient.getInstance().getApi().verify(code);
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (response.code() == 200){

                    Toast.makeText(VerifyCode.this, "Account verified", Toast.LENGTH_LONG).show();
                    vProgressbar.setVisibility(View.INVISIBLE);
                    Intent completeIntent = new Intent(VerifyCode.this, CompleteRegistration.class);
                    completeIntent.putExtra("token", token);
                    startActivity(completeIntent);

                } else {
                    Toast.makeText(VerifyCode.this, "Account already exist", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {

            }
        });

//        ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);
//        Data data = new Data(code);
//
//        apiInterface.verify(data.getVerifyCode()).enqueue(new Callback<Data>() {
//            @Override
//            public void onResponse(Call<Data> call, Response<Data> response) {
//                if (response.code() == 200){
//
//                    Toast.makeText(VerifyCode.this, "Account Verified", Toast.LENGTH_LONG).show();
//                    vProgressbar.setVisibility(View.INVISIBLE);
//                    Intent completeIntent = new Intent(VerifyCode.this, CompleteRegistration.class);
//                    completeIntent.putExtra("token", token);
//                    startActivity(completeIntent);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Data> call, Throwable t){
//                Toast.makeText(VerifyCode.this, t.getMessage(), Toast.LENGTH_LONG).show();
//                vProgressbar.setVisibility(View.INVISIBLE);
//            }
//        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}

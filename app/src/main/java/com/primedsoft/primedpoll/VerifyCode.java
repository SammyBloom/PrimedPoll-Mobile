package com.primedsoft.primedpoll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.primedsoft.primedpoll.activity.Polls;

public class VerifyCode extends AppCompatActivity {
    Button verification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_code);

        Toolbar verifyToolbar = findViewById(R.id.verifycode_toolbar);
        setSupportActionBar(verifyToolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        verification = findViewById(R.id.verify);
        verification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent verifyIntent = new Intent(VerifyCode.this, Polls.class);
                startActivity(verifyIntent);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}

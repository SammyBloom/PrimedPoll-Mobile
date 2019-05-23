package com.primedsoft.primedpoll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class CompleteRegistration extends AppCompatActivity {

    private EditText first_name, last_name, cellNo, birthDate;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_registration);

        first_name = findViewById(R.id.firstName);
        last_name = findViewById(R.id.lastName);
        cellNo = findViewById(R.id.cell_no);
        birthDate = findViewById(R.id.birth_date);

        token = getIntent().getStringExtra("token");

        completeReg();
    }

    private void completeReg() {

        final String fName = first_name.getText().toString().trim();
        final String lName = last_name.getText().toString().trim();
        final String phoneCell = cellNo.getText().toString().trim();
        final String bornDay = birthDate.getText().toString().trim();

        if (fName.isEmpty()){
            first_name.setError("Enter First Name");
            return;
        }

        if (lName.isEmpty()){
            last_name.setError("Enter Last Name");
            return;
        }

        if (phoneCell.isEmpty()){
            cellNo.setError("Enter Phone Number");
            return;
        }

        if (bornDay.isEmpty()){
            birthDate.setError("Enter Day of Birth");
            return;
        }


    }

}

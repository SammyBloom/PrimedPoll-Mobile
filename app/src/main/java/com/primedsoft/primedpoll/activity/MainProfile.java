package com.primedsoft.primedpoll.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.primedsoft.primedpoll.Adapter.InterestAdapter;
import com.primedsoft.primedpoll.EditProfile;
import com.primedsoft.primedpoll.R;

public class MainProfile extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    public static final String GOOGLE_ACCOUNT = "google_account";
    private TextView profileName, edit_profile, profileEmail, profilePhone, profileDOB;
    private ImageView profileImage;
    private InterestAdapter mAdapter;
    private RecyclerView myInterest;
    private GoogleSignInOptions gso;
    private GoogleApiClient googleApiClient;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);
//
        Toolbar myToolbar = (Toolbar) findViewById(R.id.profile_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        profileName = findViewById(R.id.username);
//        profileImage = findViewById(R.id.profile_image);
        edit_profile = findViewById(R.id.edit_profile);
        profileEmail = findViewById(R.id.email);
        profilePhone = findViewById(R.id.phone_no);
        profileDOB = findViewById(R.id.D_O_B);

        myInterest = findViewById(R.id.recycler_main);

        token = getIntent().getStringExtra("token");

        showUserDetails();

//        Picasso.get().load(R.drawable.profile_pic).transform(new com.primedsoft.primedpoll.CircleTransform()).into(profileImage);

//        To get necessary info from google
        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editProfile();
            }
        });

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }

    private void showUserDetails() {


    }

    public void editProfile(){
        Intent editProfIntent = new Intent(MainProfile.this, EditProfile.class);
        startActivity(editProfIntent);
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    /**
     * Called when pointer capture is enabled or disabled for the current window.
     *
     * @param hasCapture True if the window has pointer capture.
     */
    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient);
//        if (opr.isDone()) {
//            GoogleSignInResult result = opr.get();
//            handleSignInResult(result);
//        } else {
//            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
//                @Override
//                public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
//                    handleSignInResult(googleSignInResult);
//                }
//            });
//        }
//    }
//
//    private void handleSignInResult(GoogleSignInResult result) {
//        if (result.isSuccess()) {
//            GoogleSignInAccount account = result.getSignInAccount();
//            user_name.setText(account.getDisplayName());
//            user_email.setText(account.getEmail());
//            try {
//                Picasso.get()
//                        .load(account.getPhotoUrl())
//                        .transform(new CircleTransform())
//                        .into(profile_img);
//            } catch (NullPointerException e) {
//                Toast.makeText(getApplicationContext(), "image not found", Toast.LENGTH_LONG).show();
//            }
//
//        } else {
//            gotoMainActivity();
//        }
//    }

    public void clickEdit(android.view.View v) {
        switch (v.getId()) {
//            case R.id.profile_image_user:
////                do something
//                break;
            case R.id.username_user:

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainProfile.this);
                alertDialog.setTitle("NAME");
                alertDialog.setMessage("Enter Name");

                final EditText input_name = new EditText(MainProfile.this);
                LinearLayout.LayoutParams layout = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input_name.setLayoutParams(layout);
                alertDialog.setView(input_name);
//        alertDialog.setIcon(R.drawable.);

                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = input_name.getText().toString().trim();
                    }
                });
                break;
            case R.id.email:
//                do something
                AlertDialog.Builder alertDialog_email = new AlertDialog.Builder(MainProfile.this);
                alertDialog_email.setTitle("EMAIL");
                alertDialog_email.setMessage("Enter Email");

                final EditText input_email = new EditText(MainProfile.this);
                LinearLayout.LayoutParams layout_email = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input_email.setLayoutParams(layout_email);
                alertDialog_email.setView(input_email);
//        alertDialog.setIcon(R.drawable.);

                alertDialog_email.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = input_email.getText().toString().trim();
                    }
                });
                break;
            case R.id.phone_no:
//                do something
                AlertDialog.Builder alertDialog_phone = new AlertDialog.Builder(MainProfile.this);
                alertDialog_phone.setTitle("EMAIL");
                alertDialog_phone.setMessage("Enter Email");

                final EditText input_phone = new EditText(MainProfile.this);
                LinearLayout.LayoutParams layout_phone = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input_phone.setLayoutParams(layout_phone);
                alertDialog_phone.setView(input_phone);
//        alertDialog.setIcon(R.drawable.);

                alertDialog_phone.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = input_phone.getText().toString().trim();
                    }
                });
                break;
            case R.id.D_O_B:
//                do something
                AlertDialog.Builder alertDialog_dob = new AlertDialog.Builder(MainProfile.this);
                alertDialog_dob.setTitle("DATE OF BIRTH");
                alertDialog_dob.setMessage("Enter Date of Birth");

                final EditText input_dob = new EditText(MainProfile.this);
                LinearLayout.LayoutParams layout_dob = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input_dob.setLayoutParams(layout_dob);
                alertDialog_dob.setView(input_dob);

                break;
        }
    }
}

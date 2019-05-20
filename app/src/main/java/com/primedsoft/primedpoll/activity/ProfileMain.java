package com.primedsoft.primedpoll.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.primedsoft.primedpoll.Adapter.InterestAdapter;
import com.primedsoft.primedpoll.EditProfile;
import com.primedsoft.primedpoll.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileMain extends AppCompatActivity {

    public static final String GOOGLE_ACCOUNT = "google_account";
    private TextView profileName, edit_profile;
    private CircleImageView profileImage;
    private InterestAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.profile_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        profileName = findViewById(R.id.username);
        profileImage = findViewById(R.id.profile_image);
        edit_profile = findViewById(R.id.edit_profile);

        edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editProfile();
            }
        });
    }

    public void editProfile(){
        Intent editProfIntent = new Intent(ProfileMain.this, EditProfile.class);
        startActivity(editProfIntent);
    }
}

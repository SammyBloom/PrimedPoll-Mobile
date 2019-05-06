package com.primedsoft.primedpoll.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.primedsoft.primedpoll.Adapter.InterestAdapter;
import com.primedsoft.primedpoll.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileMain extends AppCompatActivity {

    public static final String GOOGLE_ACCOUNT = "google_account";
    private TextView profileName, bio;
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
        bio = findViewById(R.id.bio);
    }
}

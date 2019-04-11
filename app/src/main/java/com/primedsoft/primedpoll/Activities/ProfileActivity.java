package com.primedsoft.primedpoll.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.primedsoft.primedpoll.R;

public class ProfileActivity extends AppCompatActivity {
        public static final String GOOGLE_ACCOUNT = "google_account";
        private TextView profileName, profileEmail;
        private ImageView profileImage;
        private Button signOut;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_profile);

        }

    }


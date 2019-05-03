package com.primedsoft.primedpoll.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.primedsoft.primedpoll.Adapter.InterestAdapter;
import com.primedsoft.primedpoll.R;

public class ProfileUser extends AppCompatActivity {

    private TextView user_name, user_email, user_phone, user_dob;
    private ImageView profile_img;
    private RecyclerView myInterest;
    private InterestAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.profile_user_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        profile_img = findViewById(R.id.profile_image_user);
        user_name = findViewById(R.id.username_user);
        user_email = findViewById(R.id.email);
        user_phone = findViewById(R.id.phone_no);
        user_dob = findViewById(R.id.D_O_B);

        myInterest = findViewById(R.id.recycler_interest);
////        Rounded images using picasso
//        Picasso.get().load().placeholder(R.drawable.profile_pic).transform(new CircleTransform()).into(profile_img);
    }

    public void clickEdit(android.view.View v){
        switch (v.getId()){
            case R.id.profile_image_user:
//                do something
                break;
            case R.id.username_user:

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(ProfileUser.this);
                alertDialog.setTitle("NAME");
                alertDialog.setMessage("Enter Name");

                final EditText input_name = new EditText(ProfileUser.this);
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
                AlertDialog.Builder alertDialog_email = new AlertDialog.Builder(ProfileUser.this);
                alertDialog_email.setTitle("EMAIL");
                alertDialog_email.setMessage("Enter Email");

                final EditText input_email = new EditText(ProfileUser.this);
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
                AlertDialog.Builder alertDialog_phone = new AlertDialog.Builder(ProfileUser.this);
                alertDialog_phone.setTitle("EMAIL");
                alertDialog_phone.setMessage("Enter Email");

                final EditText input_phone = new EditText(ProfileUser.this);
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
                AlertDialog.Builder alertDialog_dob = new AlertDialog.Builder(ProfileUser.this);
                alertDialog_dob.setTitle("DATE OF BIRTH");
                alertDialog_dob.setMessage("Enter Date of Birth");

                final EditText input_dob = new EditText(ProfileUser.this);
                LinearLayout.LayoutParams layout_dob = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input_dob.setLayoutParams(layout_dob);
                alertDialog_dob.setView(input_dob);

                break;
        }
    }
}

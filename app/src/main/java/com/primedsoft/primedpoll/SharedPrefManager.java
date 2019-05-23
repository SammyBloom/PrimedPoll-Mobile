package com.primedsoft.primedpoll;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    private static final String SHARED_PREF_NAME = "my_shared_pref_name";
    private static final String SHARED_PREF_KEY = "my_shared_pref_name_String";
    private static SharedPrefManager myInstance;

    private static final String ID = "id";
    private static final String FIRSTNAME = "first_name";
    private static final String LASTNAME = "last_name";
    private static final String EMAIL = "email";
    private static final String PROFILE_PIC = "image";
    private static final String PHONE = "phone";
    private static final String BIO = "bio";
    private static final String DOB = "dob";
    private static final String CREATED = "created_at";
    private static final String UPDATED = "updated_at";
    private static final String TOKEN = "token";

    private Context mCtx;

    public SharedPrefManager(Context context){
        this.mCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context mCtx){

        if (myInstance == null){
            myInstance = new SharedPrefManager(mCtx);
        }
        return myInstance;
    }

    public void save(User user){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

//        editor.putFloat("id", user.getId());
//        editor.putString("first_name", user.getFirst_name());
//        editor.putString("last_name", user.getLast_name());
        editor.putString("email", user.getEmail());
//        editor.putString("image", user.getImage());
//        editor.putString("phone", user.getPhone());
//        editor.putString("bio", user.getBio());
//        editor.putString("dob", user.getDob());
//        editor.putString("created_at", user.getCreated_at());
//        editor.putString("updated_at", user.getUpdated_at());

        editor.apply();
    }

    public User getSavedInfo(){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        return new User(
                sharedPreferences.getFloat(ID, 0),
                sharedPreferences.getString(FIRSTNAME, ""),
                sharedPreferences.getString(LASTNAME, ""),
                sharedPreferences.getString(EMAIL, ""),
                sharedPreferences.getString(PROFILE_PIC, ""),
                sharedPreferences.getString(PHONE, ""),
                sharedPreferences.getString(BIO, ""),
                sharedPreferences.getString(DOB, ""),
                sharedPreferences.getString(CREATED, ""),
                sharedPreferences.getString(UPDATED, "")
        );
    }

    public boolean logout(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.clear();
        editor.apply();

        return true;
    }

}

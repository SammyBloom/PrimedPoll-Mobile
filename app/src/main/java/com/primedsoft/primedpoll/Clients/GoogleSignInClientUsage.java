package com.primedsoft.primedpoll.Clients;

import android.content.Context;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;


public class GoogleSignInClientUsage {
    public GoogleSignInClient getGoogleSignInClient(Context context, GoogleSignInOptions gso) {
        GoogleSignInClient googleSignInClient;
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestProfile()
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(context, gso);
        return googleSignInClient;
    }


}



package com.primedsoft.primedpoll.api;

import com.primedsoft.primedpoll.TLSSocketFactory;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static OkHttpClient client = new OkHttpClient();
    private static Retrofit retrofit = null;
    public static final String BASE_URL = "http://13.59.91.161:8000/";


    public static Retrofit getRetrofitInstance() {
        try {
            client = new OkHttpClient.Builder().sslSocketFactory(new TLSSocketFactory()).build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}



package com.primedsoft.primedpoll.api;

import com.primedsoft.primedpoll.Data;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {
@FormUrlEncoded
    @POST("api/register")
    Call<Data> register(@Field("email") String email,
                     @Field("password") String password,
                     @Field("password_confirmation") String confirmPassword);

    @GET("register/verify/{verifyToken}")
    Call<Data> verification(@Header("Authorization") String token);


    @FormUrlEncoded
    @POST("api/user/login")
    Call<Data> login(@Field("email") String email,
                        @Field("password") String password);
@FormUrlEncoded
   @POST("api/password/reset")
    Call<Data> resetPassword(@Field("email") String email);

    @FormUrlEncoded
    @POST("api/password/change ")
    Call<Data> changePassword(@Field("email") String email,
                              @Field(""));



}


}

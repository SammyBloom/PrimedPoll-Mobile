package com.primedsoft.primedpoll.api;

import com.primedsoft.primedpoll.Data;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
@FormUrlEncoded
    @POST("api/register")
    Call<Data> register(@Field("email") String email,
                     @Field("password") String password,
                     @Field("password_confirmation") String confirmPassword);


    @FormUrlEncoded
    @POST("api/user/login")
    Call<Data> login(@Field("email") String email,
                        @Field("password") String password);
    @FormUrlEncoded
    @POST("api/password/reset")
    Call<Data> resetPassword(@Field("email") String email);

    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @PUT("api/password/change")
    Call<Data> changePassword(@Field("email") String email,
                            @Field("verifycode") String verifyCode,
                              @Field("newpassword") String newPassword,
                              @Field("verifypassword") String verifyPassword);

    @FormUrlEncoded
    @POST("api/register/verify")
    Call<Data> verify(@Field("verifycode") String verifycode);





}

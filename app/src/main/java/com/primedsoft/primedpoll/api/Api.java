package com.primedsoft.primedpoll.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> register(
                    @Field("name") String username,
                    @Field("email") String email,
                    @Field("phone_number") String phoneNo,
                    @Field("password") String password,
                    @Field("password_confirmation") String cnfPassword
            );

}

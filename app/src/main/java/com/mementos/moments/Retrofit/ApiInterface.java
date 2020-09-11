package com.mementos.moments.Retrofit;

import com.mementos.moments.Model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("register")
    Call<User> postRegister(@Field("uid") String uid,
                            @Field("name") String name);
}

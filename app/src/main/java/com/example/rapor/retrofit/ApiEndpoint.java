package com.example.rapor.retrofit;

import com.example.rapor.model.login.LData;
import com.example.rapor.model.login.Login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiEndpoint {

    @FormUrlEncoded
    @POST("ceklogin.php")
    Call<Login> loginResponse(
            @Field("email") String email,
            @Field("password") String password
    );
}

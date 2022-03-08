package com.example.jsonplaceholder.API;

import com.example.jsonplaceholder.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRequest {
    @GET("users")
    Call<List<User>> getUser();
}

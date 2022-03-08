package com.example.jsonplaceholder.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServe {
    private static Retrofit retro;
    private static final String baseUrl ="https://jsonplaceholder.typicode.com/";

    public static Retrofit konekRetrofit(){
        if (retro == null){
            retro = new  Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retro;
    }
}

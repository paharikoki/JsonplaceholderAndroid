package com.example.jsonplaceholder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.jsonplaceholder.API.APIRequest;
import com.example.jsonplaceholder.API.RetrofitServe;
import com.example.jsonplaceholder.Adapter.Adapter;
import com.example.jsonplaceholder.DB.DBUser;
import com.example.jsonplaceholder.Model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        getData();

    }
    public void getData(){
        //dbUser.userDao().deleteUsers();
         DBUser dbUser = DBUser.getDbUser(this);

        APIRequest apiRequest = RetrofitServe.konekRetrofit().create(APIRequest.class);
        Call<List<User>> listUser = apiRequest.getUser();
        listUser.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.d("Success","Berhasil");
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("Error","Error Get User");
                t.printStackTrace();
            }
        });
    }
}
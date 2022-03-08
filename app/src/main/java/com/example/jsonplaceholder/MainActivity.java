package com.example.jsonplaceholder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.jsonplaceholder.API.APIRequest;
import com.example.jsonplaceholder.API.RetrofitServe;
import com.example.jsonplaceholder.Adapter.Adapter;
import com.example.jsonplaceholder.Model.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvData;
    private Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvData = findViewById(R.id.rv_data);
        getData();
    }

    public void getData(){
        APIRequest apiRequest = RetrofitServe.konekRetrofit().create(APIRequest.class);
        Call<List<User>> listUser = apiRequest.getUser();
        listUser.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.d("Success","Berhasil");
                userList =  response.body();
                adData = new Adapter(userList);
                rvData.setAdapter(adData);
                //adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("Error","Error Get User");
                t.printStackTrace();
            }
        });
    }
}
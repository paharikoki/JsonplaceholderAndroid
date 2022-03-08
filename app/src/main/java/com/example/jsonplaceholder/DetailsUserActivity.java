package com.example.jsonplaceholder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsUserActivity extends AppCompatActivity {
    private TextView tvnama,tvemail,tvwebsite,tvcity;
    private String nama,email,website,city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_user);

        setTitle("Details User");

        tvnama = findViewById(R.id.tv_nama);
        tvemail = findViewById(R.id.tv_email);
        tvwebsite = findViewById(R.id.tv_website);
        tvcity = findViewById(R.id.tv_city);

        nama = getIntent().getStringExtra("name");
        email = getIntent().getStringExtra("email");
        website = getIntent().getStringExtra("website");
        city = getIntent().getStringExtra("city");

        tvnama.setText(getString(R.string.nama,nama));
        tvemail.setText(getString(R.string.email,email));
        tvwebsite.setText(getString(R.string.website,website));
        tvcity.setText(getString(R.string.city,city));
    }
}
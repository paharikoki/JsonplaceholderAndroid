package com.example.jsonplaceholder.Adapter.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholder.R;

public class HolderData extends RecyclerView.ViewHolder {
    public TextView tvnama,tvemail,tvwebsite,tvcity;
    public HolderData(@NonNull View itemView) {
        super(itemView);

        tvnama = itemView.findViewById(R.id.et_nama);
        tvemail = itemView.findViewById(R.id.et_email);
        tvwebsite = itemView.findViewById(R.id.et_website);
        tvcity = itemView.findViewById(R.id.et_city);
    }
}

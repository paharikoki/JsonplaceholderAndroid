package com.example.jsonplaceholder.Adapter;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jsonplaceholder.Adapter.ViewHolder.HolderData;
import com.example.jsonplaceholder.DetailsUserActivity;
import com.example.jsonplaceholder.MainActivity;
import com.example.jsonplaceholder.Model.User;
import com.example.jsonplaceholder.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<HolderData>{
    private List<User> userList;
    private AlertDialog.Builder dialog;

    public Adapter(List<User> userList) {

        this.userList = userList;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        return new HolderData(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {

        User dm = userList.get(position);
        holder.tvnama.setText(dm.getName());
        holder.tvemail.setText(dm.getEmail());
        holder.tvwebsite.setText(dm.getWebsite());
        //holder.tvcity.setText(dm.getAddress().getCity());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                Intent intentDetails = new Intent(view.getContext(),DetailsUserActivity.class);
//                intentDetails.putExtra("website",dm.getWebsite());
//                intentDetails.putExtra("name",dm.getName());
//                intentDetails.putExtra("email",dm.getEmail());
//                intentDetails.putExtra("city",dm.getAddress().getCity());
//                view.getContext().startActivity(intentDetails);
//            }
//        });


        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                final CharSequence[] dialogitems = {"tampil"};
                dialog = new AlertDialog.Builder(view.getContext());
                dialog.setItems(dialogitems,(dialogInterface, i) -> {
                    switch (i){
                        case 0:
                            Intent intentDetails = new Intent(view.getContext(),DetailsUserActivity.class);
                            intentDetails.putExtra("website",dm.getWebsite());
                            intentDetails.putExtra("name",dm.getName());
                            intentDetails.putExtra("email",dm.getEmail());
                            //intentDetails.putExtra("city",dm.getAddress().getCity());
                            view.getContext().startActivity(intentDetails);
                            break;
                    }
                }).show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


}

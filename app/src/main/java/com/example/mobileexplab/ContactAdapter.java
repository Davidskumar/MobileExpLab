package com.example.mobileexplab;

import android.content.Context;
import android.content.pm.LauncherActivityInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactViewHolder> {
    List<String> nlist;
    List<String> nolist;
    LayoutInflater layoutInflater;
    int image[];
    ContactAdapter(Context context,List<String> nlist,List<String> nolist,int image[]){
        this.nlist=nlist;
        this.nolist=nolist;
        this.image=image;
        layoutInflater= LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.activity_fourth1,parent,false);
        return new ContactViewHolder(view,nolist);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        holder.nameTextView.setText(nlist.get(position));
        holder.numberTextView.setText(nolist.get(position));
        holder.imageView.setImageResource(image[position]);
    }

    @Override
    public int getItemCount() {
        return nlist.size();
    }
}

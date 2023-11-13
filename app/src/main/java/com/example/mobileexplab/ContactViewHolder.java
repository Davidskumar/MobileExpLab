package com.example.mobileexplab;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.invoke.ConstantCallSite;
import java.util.List;

public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView imageView;
    public TextView nameTextView,numberTextView;
    List<String> nolist;

    public ContactViewHolder(@NonNull View itemView, List<String> nolist){
        super(itemView);
        itemView.setOnClickListener(this);
        imageView = itemView.findViewById(R.id.imageView);
        nameTextView = itemView.findViewById(R.id.nameId);
        numberTextView = itemView.findViewById(R.id.numberId);
        this.nolist = nolist;
    }
    @Override
    public void onClick(View v) {
        int pos = getAdapterPosition();
        String ele = nolist.get(pos);
        Context context = v.getContext();
        context.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ele)));

    }
}

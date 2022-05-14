package com.udb.edu.guia6.dogapivc190544;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import com.udb.edu.guia6.dogapivc190544.databinding.ItemDogBinding;

public class DogViewHolder extends RecyclerView.ViewHolder {
    private com.udb.edu.guia6.dogapivc190544.databinding.ItemDogBinding itemDogBinding;

    public DogViewHolder(@NonNull View itemView) {
        super(itemView);
        itemDogBinding = ItemDogBinding.bind(itemView);
    }

    public void bind(String imageUrl) {
        Picasso.get().load(imageUrl).into(itemDogBinding.ivDog);
    }

}

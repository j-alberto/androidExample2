package com.example.jarojas.example.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jarojas.example.R;
import com.example.jarojas.example.model.Pet;

import java.util.List;

/**
 * Created by jarojas on 27/03/17.
 */

public class MyPetRecyclerViewAdapter extends RecyclerView.Adapter<MyPetRecyclerViewAdapter.ViewHolder>{

    private List<Pet> petList;

    public MyPetRecyclerViewAdapter(List<Pet> petList) {
        this.petList = petList;
    }

    @Override
    public MyPetRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_pet_item,parent,false);

        return new MyPetRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyPetRecyclerViewAdapter.ViewHolder holder, int position) {
        Pet pet = petList.get(position);
        holder.tvRating.setText(""+pet.getRating());
        holder.ivPetImage.setImageResource(pet.getPhotoId());

    }

    @Override
    public int getItemCount() {
        return petList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvRating;
        private final ImageView ivPetImage;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tvRating = (TextView) itemView.findViewById(R.id.tvMyPetRating);
            this.ivPetImage = (ImageView) itemView.findViewById(R.id.ivMyPetImage);
        }
    }
}

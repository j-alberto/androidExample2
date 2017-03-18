package com.example.jarojas.example;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jarojas on 17/03/17.
 */

public class PetRecyclerViewAdapter extends RecyclerView.Adapter<PetRecyclerViewAdapter.ViewHolder>{

    private List<Pet> pets;

    public PetRecyclerViewAdapter(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pet pet = pets.get(position);
        holder.tvName.setText(pet.getName());
        holder.tvRating.setText(""+pet.getRating());
        holder.ivPetImage.setImageResource(pet.getPhotoId());

    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvName;
        private final TextView tvRating;
        private final ImageView ivPetImage;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tvName = (TextView) itemView.findViewById(R.id.tvName);
            this.tvRating = (TextView) itemView.findViewById(R.id.tvRating);
            this.ivPetImage = (ImageView) itemView.findViewById(R.id.ivPetImage);
        }
    }
}

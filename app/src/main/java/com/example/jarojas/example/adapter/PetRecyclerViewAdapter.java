package com.example.jarojas.example.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jarojas.example.R;
import com.example.jarojas.example.db.PetBuilder;
import com.example.jarojas.example.model.Pet;

import java.util.List;

/**
 * Created by jarojas on 17/03/17.
 */

public class PetRecyclerViewAdapter extends RecyclerView.Adapter<PetRecyclerViewAdapter.ViewHolder>{

    private List<Pet> pets;
    PetBuilder petBuilder;

    public PetRecyclerViewAdapter(List<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_item,parent,false);
        petBuilder = new PetBuilder(view.getContext());

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Pet pet = pets.get(position);
        holder.tvName.setText(pet.getName());
        holder.tvRating.setText(""+pet.getRating());
        holder.ivPetImage.setImageResource(pet.getPhotoId());

        holder.ivBoneLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pet.setRating(petBuilder.addOneLike(pet));
                holder.tvRating.setText(""+pet.getRating());
                Toast.makeText(v.getContext(),"Diste like a "+pet.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvName;
        private final TextView tvRating;
        private final ImageView ivPetImage;
        private final ImageView ivBoneLike;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tvName = (TextView) itemView.findViewById(R.id.tvName);
            this.tvRating = (TextView) itemView.findViewById(R.id.tvRating);
            this.ivPetImage = (ImageView) itemView.findViewById(R.id.ivPetImage);
            this.ivBoneLike = (ImageView) itemView.findViewById(R.id.ivBoneLike);
        }
    }
}

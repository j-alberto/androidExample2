package com.example.jarojas.example.model;

import com.example.jarojas.example.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jarojas on 18/03/17.
 */

public class PetDataset {

    public static final List<Pet> PET_LIST = Arrays.asList(
            new Pet("Bugs",4,true, R.drawable.bunny1),
            new Pet("El Patas",7,true,R.drawable.bunny2),
            new Pet("Tweety",2,false,R.drawable.canary1),
            new Pet("Lucas",1,false,R.drawable.duck1),
            new Pet("Patricio",2,true,R.drawable.duck2),
            new Pet("Hamtaro",5,true,R.drawable.hamster1),
            new Pet("Ratatuille",3,false,R.drawable.hamster2),
            new Pet("Cucho",11,false,R.drawable.kitty1),
            new Pet("Tigro",22,false,R.drawable.kitty2),
            new Pet("Don Griton",2,false,R.drawable.periquito1)
    );

    public  static final List<Pet> FAVORITES = Arrays.asList(
            PET_LIST.get(1),
            PET_LIST.get(2),
            PET_LIST.get(5),
            PET_LIST.get(7),
            PET_LIST.get(8)
    );

    public static final List<Pet> MY_PET_LIST = Arrays.asList(
            new Pet(7,R.drawable.bunny1),
            new Pet(2,R.drawable.bunny2),
            new Pet(0,R.drawable.bunny1),
            new Pet(2,R.drawable.bunny2),
            new Pet(9,R.drawable.bunny1),
            new Pet(12,R.drawable.bunny1),
            new Pet(9,R.drawable.bunny2),
            new Pet(1,R.drawable.bunny2),
            new Pet(3,R.drawable.bunny1),
            new Pet(4,R.drawable.bunny2),
            new Pet(11,R.drawable.bunny1),
            new Pet(4,R.drawable.bunny2));

}

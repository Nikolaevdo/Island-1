package com.javarush.island.nikolaev.entity.organizms.animals.herbivores;

import com.javarush.island.nikolaev.entity.organizms.Limit;
import com.javarush.island.nikolaev.entity.organizms.animals.Animal;

public abstract class Herbivore extends Animal {
    public Herbivore(String name, String icon, double weight, int idFromTheSpecTable, Limit limit) {
        super(name, icon, weight,idFromTheSpecTable, limit);}
}

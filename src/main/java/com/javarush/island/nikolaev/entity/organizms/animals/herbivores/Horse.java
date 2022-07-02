package com.javarush.island.nikolaev.entity.organizms.animals.herbivores;

import com.javarush.island.nikolaev.abstraction.annotations.Setting;
import com.javarush.island.nikolaev.entity.organizms.Limit;

@Setting(name = "Лошадка", icon = "\uD83D\uDC0E", maxWeight = 400, maxCount = 20, maxSpeed = 4, maxFood = 60, idFromTheSpecTable = 5)
public class Horse extends Herbivore {

    public Horse(String name, String icon, double weight, int idFromTheSpecTable, Limit limit)
        {super(name, icon, weight,idFromTheSpecTable, limit);}
}

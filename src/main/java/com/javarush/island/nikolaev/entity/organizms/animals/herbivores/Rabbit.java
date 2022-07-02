package com.javarush.island.nikolaev.entity.organizms.animals.herbivores;

import com.javarush.island.nikolaev.abstraction.annotations.Setting;
import com.javarush.island.nikolaev.entity.organizms.Limit;

@Setting(name = "Rabbit", icon = "\uD83D\uDC01", maxWeight = 2, maxCount = 150, maxSpeed = 2, maxFood = 0.45, idFromTheSpecTable = 7)

public class Rabbit  extends Herbivore {

    public Rabbit (String name, String icon, double weight, int idFromTheSpecTable, Limit limit)
        {super(name, icon, weight,idFromTheSpecTable, limit);}
}

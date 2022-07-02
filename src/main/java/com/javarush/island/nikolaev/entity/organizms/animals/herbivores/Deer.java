package com.javarush.island.nikolaev.entity.organizms.animals.herbivores;

import com.javarush.island.nikolaev.abstraction.annotations.Setting;
import com.javarush.island.nikolaev.entity.organizms.Limit;

@Setting(name = "Deer", icon = "\uD83D\uDC03", maxWeight = 500, maxCount = 5, maxSpeed = 2, maxFood = 80, idFromTheSpecTable = 6)

public class Deer extends Herbivore {

    public Deer (String name, String icon, double weight, int idFromTheSpecTable, Limit limit)
        {super(name, icon, weight,idFromTheSpecTable, limit);}
}

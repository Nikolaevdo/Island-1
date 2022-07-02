package com.javarush.island.nikolaev.entity.organizms.animals.herbivores;

import com.javarush.island.nikolaev.abstraction.annotations.Setting;
import com.javarush.island.nikolaev.entity.organizms.Limit;

@Setting(name = "Сaterpillar", icon = "\uD83D\uDC1B", maxWeight = 0.01, maxCount = 1000, maxSpeed = 0, maxFood = 1, idFromTheSpecTable = 13)

public class Caterpillar extends Herbivore {

    public Caterpillar(String name, String icon, double weight,int idFromTheSpecTable, Limit limit)
        {super(name, icon, weight,idFromTheSpecTable, limit);}
}

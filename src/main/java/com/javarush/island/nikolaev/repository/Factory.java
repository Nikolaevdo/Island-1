package com.javarush.island.nikolaev.repository;

import com.javarush.island.nikolaev.entity.map.Cell;
import com.javarush.island.nikolaev.entity.organizms.Organism;

import java.util.List;

public interface Factory {

    Cell createRandomCell();

    List<Organism> getAllPrototypes();

}

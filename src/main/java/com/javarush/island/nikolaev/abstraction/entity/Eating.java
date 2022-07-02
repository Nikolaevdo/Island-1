package com.javarush.island.nikolaev.abstraction.entity;

import com.javarush.island.nikolaev.entity.map.Cell;

@FunctionalInterface
public interface Eating {

    boolean eat(Cell currentCell);

}
package ru.javarush.island.khmelov.entity.organizms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.javarush.island.khmelov.entity.map.Cell;
import ru.javarush.island.khmelov.entity.map.GameMap;
import ru.javarush.island.khmelov.entity.organizms.animals.predators.Wolf;
import ru.javarush.island.khmelov.repository.EntityFactory;
import ru.javarush.island.khmelov.repository.Factory;
import ru.javarush.island.khmelov.repository.GameMapCreator;

import java.util.Map;

class OrganismTest {


    private GameMap map;
    private Wolf wolf;
    private Cell startCell;
    private double delta;

    @BeforeEach
    void setUp() {
        Factory factory = new EntityFactory();
        GameMapCreator creator = new GameMapCreator(factory);
        map = creator.createRandomFilledGameMap(3, 3, true);
        Limit limit = new Limit(100, 30, 1, 1, 1);
        wolf = new Wolf("testWolf", "W", limit);
        Cell[][] cells = map.getCells();
        startCell = cells[0][0];
        Map<String, Organisms> residents = startCell.getResidents();
        residents.get(wolf.getType()).add(wolf);
    }

    @Test
    void bornClone() {
        Assertions.assertFalse(startCell.getResidents().get(wolf.getType()).isEmpty());
        startCell.getResidents().get(wolf.getType()).add(Organism.clone(wolf));
        wolf.spawn(startCell);
        Assertions.assertEquals(3, startCell.getResidents().get(wolf.getType()).size());
    }

    @Test
    void die() {
        wolf.safeDie(startCell);
        Assertions.assertEquals(0, map.getAll().size());
    }

    @Test
    void changeWeight() {
        double expected = wolf.getWeight() + wolf.getLimit().getMaxWeight() * 10 / 100;
        wolf.safeChangeWeight(startCell, 10);
        Assertions.assertEquals(expected, wolf.getWeight());
    }

    @Test
    void move() {
        wolf.move(startCell);
        Assertions.assertTrue(startCell.getResidents().get(wolf.getType()).isEmpty());
        Assertions.assertEquals(1, map.getAll().size());
    }


    @Test
    void differentIdAfterClone() {
        Limit limit = new Limit(1, 2, 3, 4, 1);
        Wolf wolf = new Wolf("v", "i", limit);
        Wolf clone = Organism.clone(wolf);
        Assertions.assertNotEquals(wolf.getId(), clone.getId());
        Assertions.assertNotEquals(wolf, clone);
    }
}
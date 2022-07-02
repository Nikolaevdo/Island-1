package ru.javarush.island.kossatyy.entity.creatures.flora;

import lombok.Getter;
import lombok.ToString;
import ru.javarush.island.kossatyy.entity.creatures.Creature;

import java.util.concurrent.atomic.AtomicLong;

@ToString
@Getter
public class Herb extends Plant {

    private static final AtomicLong idCounter = new AtomicLong(0);

    private final long id = idCounter.getAndIncrement();

    public Herb() {
        super("\uD83C\uDF32", 15, 1000);
    }

    @Override
    public Creature spawn() {
        return new Herb();
    }
}

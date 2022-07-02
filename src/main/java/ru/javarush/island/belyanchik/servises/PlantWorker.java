package ru.javarush.island.belyanchik.servises;

import ru.javarush.island.belyanchik.bio.Herbivores.Plant;
import ru.javarush.island.belyanchik.entity.Cell;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicInteger;

//* нить, выполняющая рост растений
public class PlantWorker implements Runnable {
    private Cell cell;
    private static final String emoji = Plant.emoji;
    private static final String typeName = Plant.typeName;
    private final String threadName;
    private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1); // номер группы

    public PlantWorker(Cell cell) {
        this.cell = cell;
        this.threadName = Thread.currentThread().getThreadGroup().getName() + "-pool-" + POOL_NUMBER.getAndIncrement() + "-" + Thread.currentThread().getName();
    }

    // ежедневное создание растений
    //@Override
    public void run() {
        int total;
        Object monitor = this.cell.getMonitor();
        synchronized (monitor) { //TODO --- need just synchronized(cell.getMonitor()){...
            try {
                total = this.cell.createInOneCell(this.threadName, emoji, typeName);
                //TODO ---  and?
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                     InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}



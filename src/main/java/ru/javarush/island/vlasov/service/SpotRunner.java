package ru.javarush.island.vlasov.service;

import ru.javarush.island.vlasov.entity.Animal;
import ru.javarush.island.vlasov.entity.Nature;
import ru.javarush.island.vlasov.entity.Plant;
import ru.javarush.island.vlasov.entity.Spot;
import ru.javarush.island.vlasov.utility.Sleeper;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SpotRunner {
    private final Spot[][] spots;
    //TODO Code style. Needs reformat or extraction to methods / variables / constants
    private final int CORE_POOL_SIZE = 4;
    private final int NATURE_LIFE_PERIOD = 1;
    private final int LIFE_CYCLE = 360000;
    private final int FINAL_SHUTDOWN = 1100;

    public SpotRunner(Spot[][] spots) {
        this.spots = spots;
    }

    public void runSpots() {
        ScheduledExecutorService animalExecService = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
        ScheduledExecutorService plantExecService = Executors.newScheduledThreadPool(CORE_POOL_SIZE);
        ScheduledExecutorService statExecService = Executors.newScheduledThreadPool(CORE_POOL_SIZE);

        for (Spot[] spotArray : spots) {
            for (Spot spot : spotArray) {

                spot.makeNature();
                CopyOnWriteArrayList<Nature> nature = spot.getNature();

                statExecService.scheduleAtFixedRate(new SpotStatistics(spot), 0, NATURE_LIFE_PERIOD, TimeUnit.SECONDS);

                for (Nature species : nature) {
                    if (species instanceof Animal) {
                        animalExecService.scheduleAtFixedRate(new AnimalRunner((Animal) species, spot, animalExecService),
                                0, NATURE_LIFE_PERIOD, TimeUnit.SECONDS);
                    } else if (species instanceof Plant) {
                        plantExecService.scheduleAtFixedRate(new PlantRunner((Plant) species, spot, plantExecService),
                                0, NATURE_LIFE_PERIOD, TimeUnit.SECONDS);
                    }
                }
            }
        }

        statExecService.scheduleAtFixedRate(new IslandStatistics(spots), 0, NATURE_LIFE_PERIOD, TimeUnit.SECONDS);

        Sleeper.sleep(LIFE_CYCLE);
        animalExecService.shutdown();
        plantExecService.shutdown();
        statExecService.shutdown();

        Sleeper.sleep(FINAL_SHUTDOWN);
        animalExecService.shutdownNow();
        plantExecService.shutdownNow();
        statExecService.shutdownNow();
    }
}

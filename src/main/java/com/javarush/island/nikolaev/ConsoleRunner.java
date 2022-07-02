package com.javarush.island.nikolaev;

import com.javarush.island.nikolaev.abstraction.annotations.Setting;
import com.javarush.island.nikolaev.entity.Game;
import com.javarush.island.nikolaev.entity.map.GameMap;
import com.javarush.island.nikolaev.repository.EntityFactory;
import com.javarush.island.nikolaev.repository.Factory;
import com.javarush.island.nikolaev.repository.GameMapCreator;
import com.javarush.island.nikolaev.services.GameWorker;
import com.javarush.island.nikolaev.view.ConsoleView;
import com.javarush.island.nikolaev.view.View;

public class ConsoleRunner {
    public static void main(String[] args) {
        Factory entityFactory = new EntityFactory();
        GameMapCreator gameMapCreator = new GameMapCreator(entityFactory);
        GameMap gameMap = gameMapCreator.createRandomFilledGameMap(3,6);
        View view=new ConsoleView(gameMap);
        Game game = new Game(gameMap, entityFactory,view);
        GameWorker gameWorker = new GameWorker(game);
        gameWorker.start();
    }
}

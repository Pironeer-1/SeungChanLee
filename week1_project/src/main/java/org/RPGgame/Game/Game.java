package org.RPGgame.Game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    static List<String> log = new ArrayList<>();
    public static void pushGameLog(String log){
        Game.log.add(log);
    }

    public static void showGameLog(){

    }

    public Game() {

    }

    public static void start(){

    }
}

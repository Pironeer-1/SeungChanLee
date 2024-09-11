package org.RPGgame.Game;

import org.RPGgame.Game.io.OutputHandler;
import org.RPGgame.GameObject.Enemy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    static List<String> log = new ArrayList<>();
    private Team team;
    private Enemy enemy;
    public static void pushGameLog(String log){
        Game.log.add(log);
    }

    public static void showGameLog(){

    }

    public Game() {
        team = new Team();
        enemy = new Enemy();
    }

    public void start(){
        team.teamSetting();
        enemy.printStatus();

        while (team.isAlive()){
            // 적이 죽을때 까지 팀과 적이 번갈아 가면서 실행
            while (team.teamTurn(enemy)){
                enemy.objectTurn(team.randomPlayer());
                team.teamSetting();
            }
            enemy = new Enemy();
            OutputHandler.printNewEnemy(enemy);
            enemy.printStatus();
        }

        System.out.println(Enemy.getTotalEnemy() + "명의 적을 쓰러트렸습니다");
    }
}

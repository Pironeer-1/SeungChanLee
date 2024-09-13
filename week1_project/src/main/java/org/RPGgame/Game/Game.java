package org.RPGgame.Game;

import org.RPGgame.Game.Enum.GameEnum;
import org.RPGgame.Game.Enum.GameMessage;
import org.RPGgame.Game.io.InputHandler;
import org.RPGgame.Game.io.OutputHandler;
import org.RPGgame.GameObject.Enemy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    static List<String> log = new ArrayList<>();
    private final Team team;
    private Enemy enemy;

    public static void pushGameLog(String log){
        Game.log.add(log);
    }

    public Game() {
        team = new Team();
        enemy = new Enemy();
    }

    public void GameSetting(Team team){
        GameEnum option = InputHandler.GameInput();
        switch (option) {
            case TEAM_SETTING:
                team.teamSetting();
                break;
            case CONTINUE:
                OutputHandler.PrintGameMessage(GameMessage.MESSAGE_CONTINUE);
                break;
            case GAME_END:
                OutputHandler.PrintGameMessage(GameMessage.MESSAGE_END);
                break;
            default:
                break;
        }
    }

    public void start(){
        team.teamSetting();
        enemy.printStatus();

        while (true){
            // 적이 죽거나 팀이 다 죽을때 까지 까지 팀과 적이 번갈아 가면서 실행
            while (team.isAlive() && team.teamTurn(enemy)){
                OutputHandler.printBr();
                enemy.objectTurn(team.randomPlayer());
                OutputHandler.printBr();
                GameSetting(team);
                OutputHandler.printBr();
            }
            if(!team.isAlive()){
                break;
            }
            enemy = new Enemy();
            OutputHandler.printNewEnemy(enemy);
            enemy.printStatus();
        }

        System.out.println(Enemy.getTotalEnemy() + "명의 적을 쓰러트렸습니다");
    }
}
package org.RPGgame.Game;

import org.RPGgame.Game.Enum.GameEnum;
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
                break;
            case GAME_END:
                System.out.println("게임 종료");
                break;
            default:
                System.out.println("올바르지 않은 선택입니다. 다시 선택하세요.");
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
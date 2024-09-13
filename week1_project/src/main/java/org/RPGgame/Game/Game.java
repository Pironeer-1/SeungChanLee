package org.RPGgame.Game;

import org.RPGgame.Attack.Attack;
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

    public Game() {
        team = new Team();
        enemy = new Enemy();
    }

    public static void pushGameLog(String log){
        Game.log.add(log);
    }

    public void GameLog(){
        int attackCount = 0;
        int PattackCount = 0;
        int MattackCount = 0;
        int EattackCount = 0;
        List<Attack> attacks = Attack.AttackLogList;
        for(Attack attack : attacks){
            if(attack.getAttackerType().equals("org.RPGgame.GameObject.Player")){
                attackCount++;
                if(attack.getAttackType().equals("물리 공격")){
                    PattackCount++;
                } else {
                    MattackCount++;
                }
            } else {
                EattackCount++;
            }
        }
        System.out.println("플레이어 공격 횟수: " + attackCount);
        System.out.println("플레이어 물리 공격 횟수: " + PattackCount);
        System.out.println("플레이어 마법 공격 횟수: " + MattackCount);
        System.out.println("적들의 총 공격 횟수: " + EattackCount);
        System.out.println(Enemy.getTotalEnemy() - 1 + "명의 적을 쓰러트렸습니다");
        System.out.println(enemy.getName() + "에게 쓰러졌습니다.");
        OutputHandler.printBr();
    }

    public boolean GameSetting(Team team){
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
                return false;
            default:
                break;
        }
        return true;
    }

    public void start(){
        team.teamSetting();
        enemy.printStatus();

        while (true){
            // 적이 죽거나 팀이 다 죽을 때까지 팀과 적이 번갈아 가면서 실행
            while (team.isAlive() && team.teamTurn(enemy)){
                OutputHandler.printBr();
                enemy.objectTurn(team.randomPlayer());
                OutputHandler.printBr();
                if(GameSetting(team)){
                    break;
                }
                OutputHandler.printBr();
            }
            if(!team.isAlive()){
                break;
            }
            if(GameSetting(team)) {
                break;
            }
            enemy = new Enemy();
            OutputHandler.printNewEnemy(enemy);
            enemy.printStatus();
        }

        GameLog();
    }

}
package org.RPGgame.Game.io;

import org.RPGgame.Game.Enum.TeamEnum;
import org.RPGgame.GameObject.Enemy;
import org.RPGgame.GameObject.Player;

import java.util.List;

public class OutputHandler {
    public static void printTeamOption(){
        System.out.println("팀을 관리해주세요:");
        System.out.print(" 1. " + TeamEnum.ADDPLAYER.getStr());
        System.out.print(" 2. " + TeamEnum.REMOVEPLAYER.getStr());
        System.out.print(" 3. " + TeamEnum.CHANGENMAE.getStr());
        System.out.print(" 4. " + TeamEnum.TEAMSTATUS.getStr());
        System.out.println(" 5. " + TeamEnum.EXIT.getStr());
    }
    public static void printInputName(){
        System.out.println("추가 할 플레이어의 이름을 입력하세요");
    }
    public static void printInputIdx(List<Player> players){
        for (int i = 0; i < players.size(); i++) {
            System.out.println(i + " 번을 누르면 삭제: " + players.get(i).getName());
        }
        System.out.println("-1을 누르면 플레이어 삭제 취소");
    }

    public static void printNewEnemy(Enemy enemy){
        System.out.println("새로운 적이 나타났습니다.");
    }
}

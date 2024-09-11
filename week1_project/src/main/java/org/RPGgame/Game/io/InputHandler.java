package org.RPGgame.Game.io;

import org.RPGgame.Game.Enum.TeamEnum;
import org.RPGgame.GameObject.Player;

import java.util.List;
import java.util.Scanner;

public class InputHandler {
    public static TeamEnum teamInput(){
        Scanner scanner = new Scanner(System.in);
        TeamEnum option = null;

        OutputHandler.printTeamOption();

        // 사용자 입력 받기
        int choice = scanner.nextInt();

        // 입력에 따라 StatOption 할당
        switch (choice) {
            case 1:
                option = TeamEnum.ADDPLAYER;
                break;
            case 2:
                option = TeamEnum.REMOVEPLAYER;
                break;
            case 3:
                option = TeamEnum.CHANGENMAE;
                break;
            case 4:
                option = TeamEnum.TEAMSTATUS;
                break;
            case 5:
                option = TeamEnum.EXIT;
                break;
            default:
                System.out.println("다시 골라주세요.");
                option = teamInput(); // 유효하지 않은 입력일 경우 재시도
                break;
        }

        return option;
    }

    public static String inputName(){
        Scanner scanner = new Scanner(System.in);

        OutputHandler.printInputName();

        return scanner.nextLine();
    }

    public static int inputPlayerIdx(List<Player> players){
        Scanner scanner = new Scanner(System.in);

        OutputHandler.printInputIdx(players);

        int input = scanner.nextInt();
        if(0 <= input && input < players.size()){
            return scanner.nextInt();
        } else if (input == -1) {
            return -1;
        } else {
            inputPlayerIdx(players);
        }
        return - 1;
    }
}

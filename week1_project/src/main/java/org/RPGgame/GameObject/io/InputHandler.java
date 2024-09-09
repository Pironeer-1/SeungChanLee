package org.RPGgame.GameObject.io;

import org.RPGgame.GameObject.Enum.ActOption;
import org.RPGgame.GameObject.Enum.StatOption;
import java.util.Scanner;

public class InputHandler {
    public static StatOption choiceAddStat(int addStat) {
        Scanner scanner = new Scanner(System.in);
        StatOption option = null;

        OutputHandler.printAddStat(addStat);

        // 사용자 입력 받기
        int choice = scanner.nextInt();

        // 입력에 따라 StatOption 할당
        switch (choice) {
            case 1:
                option = StatOption.MAX_HEALTH;
                break;
            case 2:
                option = StatOption.PHYSICAL_POWER;
                break;
            case 3:
                option = StatOption.MAGIC_POWER;
                break;
            case 4:
                option = StatOption.CRITICAL_CHANCE;
                break;
            case 5:
                option = StatOption.END;
                break;
            default:
                System.out.println("다시 골라주세요.");
                option = choiceAddStat(addStat); // 유효하지 않은 입력일 경우 재시도
                break;
        }

        return option;
    }

    public static ActOption turnInput(){
        Scanner scanner = new Scanner(System.in);
        ActOption option = null;

        OutputHandler.printActOption();

        // 사용자 입력 받기
        int choice = scanner.nextInt();

        // 입력에 따라 StatOption 할당
        switch (choice) {
            case 1:
                option = ActOption.printStatus;
                break;
            case 2:
                option = ActOption.PhysicalAttack;
                break;
            case 3:
                option = ActOption.MagicAttack;
                break;
            case 4:
                option = ActOption.healHealth;
                break;
            case 5:
                option = ActOption.distributeAddStat;
                break;
            default:
                System.out.println("다시 골라주세요.");
                option = turnInput(); // 유효하지 않은 입력일 경우 재시도
                break;
        }

        return option;
    }
}

package org.RPGgame.GameObject.io;

import org.RPGgame.GameObject.Enemy;
import org.RPGgame.GameObject.Enum.ActOption;
import org.RPGgame.GameObject.Player;
import org.RPGgame.GameObject.Enum.StatOption;

public class OutputHandler {
    public static void printPlayer(String name){
        System.out.print(name + "이(가) ");
    }

    public static void printAddStat(int addStat){
        // 선택 가능한 옵션 출력
        System.out.println("남은 스탯 포인트: " + addStat);
        System.out.println("올리고 싶은 스탯을 골라주세요:");
        System.out.print(" 1. 최대 체력(+5)");
        System.out.print(" 2. 물리 공격력(+5)");
        System.out.print(" 3. 마법 공격력(+8)");
        System.out.print(" 4. 치명타 확률(+5)");
        System.out.println(" 5. END (Exit)");
    }

    public static void failAddStat(StatOption option){
        System.out.println(option.getStr() + " 스탯을 올리는 데 실패했습니다");
    }

    public static void successAddStat(StatOption option){
        System.out.println("성공적으로 " + option.getStr() + " 스탯이 올랐습니다");
    }

    public static void endAddStat(){
        System.out.println("추가 능력치 분배를 종료합니다.");
    }

    public static void printheal(int amount){
        System.out.println(amount + "만큼 회복합니다.");
    }

    public static void printPlayerStats(Player player) {
        System.out.println("============== 플레이어 상태 ==============");
        System.out.println("플레이어 이름: " + player.getName());
        System.out.println("최대 체력: " + player.getMaxHp());
        System.out.println("현재 체력: " + player.getHealth());
        System.out.println("물리 공격력: " + player.getPhysicalPower());
        System.out.println("마법 공격력: " + player.getMagicPower());
        System.out.println("치명타 확률: " + player.getCriticalChance() + "%");
        System.out.println("남은 스탯 포인트: " + player.getAddStat());
        System.out.println("=========================================");
    }

    public static void printActOption(String name){
        System.out.println(name + "의 턴입니다");
        System.out.println("행동을 선택하세요:");
        System.out.print(" 1. " + ActOption.printStatus.getStr());
        System.out.print(" 2. " + ActOption.PhysicalAttack.getStr());
        System.out.print(" 3. " + ActOption.MagicAttack.getStr());
        System.out.print(" 4. " + ActOption.healHealth.getStr());
        System.out.println(" 5. " + ActOption.distributeAddStat.getStr());
    }

    public static void printEnemy(){
        System.out.print("적이 ");
    }

    public static void printEnemyStats(Enemy enemy) {
        System.out.println("============== 적 상태 ==============");

        // 각 메서드 결과를 변수에 저장하여 한 번만 호출
        int maxHp = enemy.getMaxHp(false);
        int health = enemy.getHealth(false);
        int physicalPower = enemy.getPhysicalPower(false);
        int physicalDefense = enemy.getPhysicalDefense(false);
        int magicDefense = enemy.getMagicDefense(false);
        int criticalChance = enemy.getCriticalChance(false);
        int idlePercent = enemy.getIdlePercent(false);

        // 최대 체력
        System.out.println("최대 체력: " + (maxHp == -1 ? "???" : maxHp));
        // 현재 체력
        System.out.println("현재 체력: " + (health == -1 ? "???" : health));
        // 물리 공격력
        System.out.println("물리 공격력: " + (physicalPower == -1 ? "???" : physicalPower));
        // 물리 방어력
        System.out.println("물리 방어력: " + (physicalDefense == -1 ? "???" : physicalDefense));
        // 마법 방어력
        System.out.println("마법 방어력: " + (magicDefense == -1 ? "???" : magicDefense));
        // 치명타 확률
        System.out.println("치명타 확률: " + (criticalChance == -1 ? "???" : criticalChance + "%"));
        // 멍때릴 확률
        System.out.println("멍때릴 확률: " + (idlePercent == -1 ? "???" : idlePercent + "%"));

        System.out.println("=========================================");
    }

    public static void printEnemyIdele(){
        System.out.println("적이 멍때리고 있습니다...");
    }
}

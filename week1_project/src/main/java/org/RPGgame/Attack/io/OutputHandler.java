package org.RPGgame.Attack.io;

public class OutputHandler {
    public static void printAttack(String attacker, int damage, String type ,String target){
        System.out.println(attacker + "이(가) " + damage + "만큼 " + type + "으로 " + target + "을(를) 공격!");
    }

    public static void printTarget(String target, int health){
        System.out.println(target + "의 남은 체력은 " + (health == -1 ? "???" : health) );
    }
}

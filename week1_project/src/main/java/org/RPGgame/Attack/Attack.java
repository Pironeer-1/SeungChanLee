package org.RPGgame.Attack;

import org.RPGgame.Attack.Enum.AttackType;
import org.RPGgame.GameObject.GameObject;

import java.util.ArrayList;
import java.util.List;

// 공격시 고려 해야 하는 건 공격 타입, 해당 파워, 치명타
public abstract class Attack {
    public static List<Attack> AttackLogList = new ArrayList<>();

    protected final GameObject attacker;
    protected final GameObject attackTarget;
    protected String attackerName;
    protected String attackerTargetName;
    protected AttackType attackType; // 공격 타입
    protected int power; // 파워에 비래해 데미지
    protected int defense; // 공격 타입에 따른 방어력
    protected int damage; // 총 데미지

    protected Attack(GameObject attacker,GameObject attackTarget) {
        this.attacker = attacker;
        this.attackTarget = attackTarget;
    }

    public String getAttackerType(){
        return attacker.getClass().getTypeName();
    }

    public String getAttackType() {
        return attackType.getStr();
    }

    public int getPower() {
        return power;
    }

    // 실제 공격 로직 실행
    public abstract void execute();
}
package org.RPGgame.GameObject;

import org.RPGgame.Game.Game;
import org.RPGgame.GameObject.Enum.StatEnum;

public abstract class GameObject {

    // 기본 속성
    protected String name;
    protected int MaxHp = StatEnum.BASE_ZERO.getStat();
    protected int health = StatEnum.BASE_ZERO.getStat();
    protected int physicalPower = StatEnum.BASE_ZERO.getStat();
    protected int magicPower = StatEnum.BASE_ZERO.getStat();
    protected int physicalDefense = StatEnum.BASE_ZERO.getStat();
    protected int magicDefense = StatEnum.BASE_ZERO.getStat();
    protected int criticalChance = StatEnum.BASE_ZERO.getStat();

    public String getName() {
        return name;
    }

    // 최대 체력
    public int getMaxHp() {
        return MaxHp;
    }

    // 체력 관련 메소드
    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > StatEnum.BASE_ZERO.getStat();
    }

    // 데미지 감소 처리
    public void decHp(int damage) {
        this.health = Math.max(this.health - damage , StatEnum.BASE_ZERO.getStat());
    }

    // 공격력 및 방어력 관련 메소드
    public int getPhysicalPower() {
        return physicalPower;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public int getPhysicalDefense() {
        return physicalDefense;
    }

    public int getMagicDefense() {
        return magicDefense;
    }

    public int getCriticalChance() {
        return criticalChance;
    }

    protected void logAction(String log){
        Game.pushGameLog(log);
    }

    // 추상 메소드: 스테이터스 출력
    public abstract void printStatus();

    // 추상 메소드: 행동 실행
    public abstract void objectTurn(GameObject target);
}
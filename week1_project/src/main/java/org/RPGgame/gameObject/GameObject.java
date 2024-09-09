package org.RPGgame.gameObject;

import org.RPGgame.Attack.Attack;

public abstract class GameObject {
    // 기본 속성
    protected int health = 1;
    protected int physicalPower = 0;
    protected int magicPower = 0;
    protected int physicalDefense = 0;
    protected int magicDefense = 0;
    protected int criticalChance = 0;

    // 체력 관련 메소드
    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    // 데미지 감소 처리
    public void decHp(int damage) {
        this.health -= damage;
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

    // 추상 메소드: 스테이터스 출력
    public abstract void printStatus();

    // 추상 메소드: 행동 실행
    public abstract void objectTurn();
}
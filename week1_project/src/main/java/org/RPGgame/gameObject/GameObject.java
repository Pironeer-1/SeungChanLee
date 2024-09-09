package org.RPGgame.gameObject;

import org.RPGgame.Attack.Attack;

public abstract class GameObject {
    // 속성
    protected int health = 1;

    public int getHealth() {
        return health;
    }

    public boolean IsAlive() {
        return health > 0;
    }

    protected int attackPower = 0;
    protected int magicPower = 0;
    protected int physicalDefense = 0;
    protected int magicDefense = 0;
    protected double criticalChance = 0.0;

    // 스테이터스 출력
    abstract public void printStatus();

    // 할 수 있는 행동을 출력하고 입력한 행동 실행
    abstract public void ObjectTurn();

    // 쳐맞는 로직, 공격 객체를 받아 처리
    public void takeDamage(Attack attack){

    };
}
package org.RPGgame.GameObject.Enum;

public enum EnemyStatEnum {
    BOSS_ROUND(5),
    STAT_WEIGHT(3),
    BASE_HP(100),
    BASE_PHYSICAL_POWER(20),
    BASE_PHYSICAL_DEFENSE(3),
    BASE_MAGIC_DEFENSE(3),
    PERCENT_HEAL(5),

    ;

    private final int stat;

    EnemyStatEnum(int stat) {
        this.stat = stat;
    }
    public int getStat() {
        return stat;
    }
}

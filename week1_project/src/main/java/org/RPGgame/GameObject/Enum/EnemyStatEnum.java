package org.RPGgame.GameObject.Enum;

public enum EnemyStatEnum {
    BOSS_ROUND(5),
    STAT_WEIGHT(3),
    BASE_HP(150),
    BASE_PHYSICAL_POWER(10),
    BASE_PHYSICAL_DEFENSE(6),
    BASE_MAGIC_DEFENSE(6),
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

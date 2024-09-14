package org.RPGgame.GameObject.Enum;

public enum EnemyStatEnum {
    BOSS_ROUND(5),
    STAT_WEIGHT(3),
    BASE_HP(150),
    BASE_PHYSICAL_POWER(9),
    BASE_PHYSICAL_DEFENSE(6),
    BASE_MAGIC_DEFENSE(6),
    PERCENT_HEAL(6),
    ;

    private final int stat;

    EnemyStatEnum(int stat) {
        this.stat = stat;
    }
    public int getStat() {
        return stat;
    }
}

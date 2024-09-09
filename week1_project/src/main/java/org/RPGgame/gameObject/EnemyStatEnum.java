package org.RPGgame.gameObject;

public enum EnemyStatEnum {
    BOSS_ROUND(5),
    STAT_WEIGHT(3),
    ;

    private final int stat;

    EnemyStatEnum(int stat) {
        this.stat = stat;
    }
    public int getStat() {
        return stat;
    }
}

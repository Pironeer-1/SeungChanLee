package org.RPGgame.GameObject.Enum;

public enum ActOption {
    printStatus("상태창"),
    PhysicalAttack("물리 공격"),
    MagicAttack("마법 공격"),
    healHealth("체력 회복"),
    distributeAddStat("스탯 분배")
    ;

    private final String str;

    ActOption(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}

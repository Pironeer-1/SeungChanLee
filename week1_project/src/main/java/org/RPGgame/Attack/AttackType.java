package org.RPGgame.Attack;

public enum AttackType {
    PHYSICAL("물리 공격"),
    MAGIC("마법 공격")
    ;

    private final String str;

    AttackType(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}

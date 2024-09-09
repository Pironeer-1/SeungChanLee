package org.RPGgame.GameObject.Enum;

public enum StatEnum {
    BASE_ZERO(0);

    private final int stat;

    StatEnum(int stat){
        this.stat = stat;
    }

    public int getStat() {
        return stat;
    }
}

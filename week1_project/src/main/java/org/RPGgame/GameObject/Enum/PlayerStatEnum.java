package org.RPGgame.GameObject.Enum;

// enum 의 맵핑은 마치 생성자를 이용해 자신을 정의
public enum PlayerStatEnum {
    // 플레이어 스탯 관련 상수
    PLAYER_BASE_HP(50),
    PLAYER_BASE_PHYSICAL_POWER(10),
    PLAYER_BASE_MAGIC_POWER(5),
    PLAYER_BASE_CRI(10),
    MAX_CRI(100),
    PLAYER_BASE_ADD_STAT(13), // 추가 스탯
    BASE_STAT_INC(1), // 스탯 증가량
    MAGIC_STAT_INC(3),// 마력은 세배
    CRI_STAT_INC(5), // 치명타는 다섯배
    PERCENT_HEAL(10),
    ;

    private final int stat;

    PlayerStatEnum(int stat){
        this.stat = stat;
    }

    public int getStat() {
        return stat;
    }
}

package org.RPGgame.GameObject.Enum;

// enum 의 맵핑은 마치 생성자를 이용해 자신을 정의
public enum PlayerStatEnum {
    // 플레이어 스탯 관련 상수
    PLAYER_BASE_HP(50),
    PLAYER_BASE_PHYSICAL_POWER(10),
    PLAYER_BASE_MAGIC_POWER(5),
    PLAYER_BASE_CRI(10),
    MAX_CRI(100),
    PLAYER_BASE_ADD_STAT(10), // 추가 스탯
    PLAYER_ACC_ADD_STAT(4), // 추가 스탯 증가량
    BASE_STAT_INC(5), // 스탯 증가량
    MAGIC_STAT_INC(8),// 마력 증가량
    CRI_STAT_INC(5), // 치명타는 다섯배
    PERCENT_HEAL(30),
    ;

    private final int stat;

    PlayerStatEnum(int stat){
        this.stat = stat;
    }

    public int getStat() {
        return stat;
    }
}

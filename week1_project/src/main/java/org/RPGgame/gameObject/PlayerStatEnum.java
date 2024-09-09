package org.RPGgame.gameObject;

// enum 의 맵핑은 마치 생성자를 이용해 자신을 정의
public enum PlayerStatEnum {
    // 플레이어 스탯 관련 상수
    PLAYER_BASE_HP(50),
    PLAYER_BASE_ATTACK_POWER(10),
    PLAYER_BASE_MAGIC_POWER(5),
    PLAYER_BASE_ADD_STAT(13), // 추가 스탯
    BASE_STAT_INC(1), // 스탯 증가량
    MAGIC_STAT_INC(3), // 마력은 세배
    ;

    private final int stat;

    PlayerStatEnum(int stat){
        this.stat = stat;
    }

    public int getStat() {
        return stat;
    }
}

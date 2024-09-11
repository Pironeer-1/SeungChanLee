package org.RPGgame.Game.Enum;

public enum TeamEnum {
    ADDPLAYER("플레이어 추가"),
    REMOVEPLAYER("플레이어 제거"),
    CHANGENMAE("플레이어 이름 변경"),
    TEAMSTATUS("팀 상태창 출력"),
    EXIT("팀 세팅 종료")
    ;

    private final String str;

    TeamEnum(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}

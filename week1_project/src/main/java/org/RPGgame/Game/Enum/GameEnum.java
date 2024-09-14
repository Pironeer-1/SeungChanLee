package org.RPGgame.Game.Enum;

public enum GameEnum {
    TEAM_SETTING("팀 세팅"),
    CONTINUE("계속 진행"),
    GAME_END("게임 종료"),
    ;
    private final String str;

    GameEnum(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}

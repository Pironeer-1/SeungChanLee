package org.RPGgame.Game.Enum;

public enum GameMessage {
    MESSAGE_CONTINUE("게임을 계속 진행합니다."),
    MESSAGE_END("게임 종료"),
    ;
    private final String str;

    GameMessage(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}

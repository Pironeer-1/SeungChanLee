package org.RPGgame.GameObject.Enum;

public enum StatOption {
    MAX_HEALTH("최대 체력"),
	PHYSICAL_POWER("물리 공격력"),
	MAGIC_POWER("마법 공격력"),
	CRITICAL_CHANCE("치명타 확률"),
	END("종료"),
	;
	
	private final String str;

	StatOption(String str) {
		this.str = str;
	}

    public String getStr() {
        return str;
    }
}


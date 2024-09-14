package org.RPGgame.GameObject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 이노테이션 한번 써보자 이걸로 행동인 거 즉, 턴을 소모하는 거를 체크
@Retention(RetentionPolicy.RUNTIME)
@interface TurnAct{
    String value();
}
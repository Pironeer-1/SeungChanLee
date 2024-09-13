package org.RPGgame.Game;

import org.RPGgame.Game.Enum.TeamEnum;
import org.RPGgame.GameObject.GameObject;
import org.RPGgame.GameObject.Player;
import org.RPGgame.Game.io.InputHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team {
    private List<Player> players;
    private int currentTurnIndex;

    public Team() {
        players = new ArrayList<>();
        currentTurnIndex = 0;
    }

    // 한명이라도 살아있다면 true
    public boolean isAlive(){
        return players.stream().anyMatch(Player::isAlive);
    }

    // 팀의 상태 출력
    public void printTeamStatus() {
        System.out.println();
        for (Player player : players) {
            player.printStatus();
        }
        System.out.println("=============================");
    }

    // 팀의 모든 플레이어 추가 스탯 주기
    public void addAddStatPlayers(){
        System.out.println("적을 물리쳐서 보상으로 랜덤 추가 스탯(0~5)을 받았습니다!!!!");
        players.forEach(Player::addAddStat);
    }

    // 팀에 플레이어 추가
    public void addPlayer(Player player) {
        players.add(player);
        System.out.println(player.getName() + "이(가) 팀에 추가되었습니다.");
    }

    // 팀에서 플레이어 삭제
    public void removePlayer(Player player) {
        players.remove(player);
        System.out.println(player.getName() + "이(가) 팀에서 삭제되었습니다.");
    }

    public Player randomPlayer(){
        Random random = new Random();

        int idx = random.nextInt(players.size());

        return players.get(idx);
    }

    // 적이 죽지 않으면 true
    public boolean teamTurn(GameObject target){
        Player currentPlayer = players.get(currentTurnIndex);
        if(currentPlayer.isAlive()){
            currentPlayer.objectTurn(target);  // 현재 플레이어의 턴 처리
        }
        else{
            System.out.println("체력이 없어 아무 것도 할 수 없습니다.");
        }
        System.out.println(currentPlayer.getName() + "의 턴이 끝났습니다.");

        // 다음 플레이어로 턴 넘기기
        currentTurnIndex = currentTurnIndex + 1;

        // 팀의 턴 종료시
        if (currentTurnIndex == players.size()) {
            currentTurnIndex = 0;
            return target.isAlive();
        }

        // 적이 살면 팀의 턴이 종료할 떄까지 재귀
        if(target.isAlive()){
            teamTurn(target);
        }

        return target.isAlive();
    }

    public void teamSetting(){
        boolean exitFlag = false;

        while (!exitFlag) {
            TeamEnum option = InputHandler.teamInput();  // 사용자 입력 받기
            // 입력에 따른 스위치 문 처리
            switch (option) {
                case ADDPLAYER:
                    String name = InputHandler.inputName();
                    addPlayer(new Player(name));
                    break;
                case REMOVEPLAYER:
                    int idx = InputHandler.inputPlayerIdx(players);
                    if(idx != -1){
                        removePlayer(players.get(idx));
                    }
                    break;
                case CHANGENMAE:
                    break;
                case TEAMSTATUS:
                    printTeamStatus();
                    break;
                case EXIT:
                    System.out.println("팀 관리 종료.");
                    exitFlag = true;  // 루프 종료
                    break;
                default:
                    System.out.println("올바르지 않은 선택입니다. 다시 선택하세요.");
                    break;
            }
        }
    }
}

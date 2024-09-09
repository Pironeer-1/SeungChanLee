package org.RPGgame.GameObject;

import org.RPGgame.Attack.Attack;
import org.RPGgame.Attack.MagicAttack;
import org.RPGgame.Attack.PhysicalAttack;
import org.RPGgame.GameObject.Enum.ActOption;
import org.RPGgame.GameObject.Enum.PlayerStatEnum;
import org.RPGgame.GameObject.Enum.StatOption;
import org.RPGgame.GameObject.io.InputHandler;
import org.RPGgame.GameObject.io.OutputHandler;


public class Player extends GameObject{
    private int addStat;
    private final String name;

    public Player(String name) {
        this.name = name;
        this.MaxHp = PlayerStatEnum.PLAYER_BASE_HP.getStat();
        this.health = PlayerStatEnum.PLAYER_BASE_HP.getStat();
        this.physicalPower = PlayerStatEnum.PLAYER_BASE_PHYSICAL_POWER.getStat();
        this.magicPower = PlayerStatEnum.PLAYER_BASE_MAGIC_POWER.getStat();
        this.criticalChance = PlayerStatEnum.PLAYER_BASE_CRI.getStat();
        this.addStat = PlayerStatEnum.PLAYER_BASE_ADD_STAT.getStat();
    }

    public int getAddStat() {
        return addStat;
    }

    // 스탯 분배
    public void distributeAddStats(){
        OutputHandler.printPlayerStats(this);
        StatOption option;
        while ((option = InputHandler.choiceAddStat(this.addStat)) != StatOption.END
                || this.addStat > 0)
        {
            boolean Eflag = false;
            switch (option) {
                case MAX_HEALTH:
                    this.MaxHp += PlayerStatEnum.BASE_STAT_INC.getStat();
                    this.health = Math.min(this.MaxHp, this.health + PlayerStatEnum.BASE_STAT_INC.getStat());
                    break;
                case PHYSICAL_POWER:
                    this.physicalPower += PlayerStatEnum.BASE_STAT_INC.getStat();
                    break;
                case MAGIC_POWER:
                    this.magicPower += PlayerStatEnum.MAGIC_STAT_INC.getStat();
                    break;
                case CRITICAL_CHANCE:
                    if(this.criticalChance >= PlayerStatEnum.MAX_CRI.getStat()){
                        Eflag = true;
                    }
                    else {
                        this.criticalChance += PlayerStatEnum.CRI_STAT_INC.getStat();
                    }
                    break;
                default:
                    break;
            }
            if(Eflag){
                OutputHandler.failAddStat(option);
            }
            else{
                this.addStat -= 1;
                OutputHandler.successAddStat(option);
            }
        }
        OutputHandler.printPlayerStats(this);
        OutputHandler.endAddStat();
    }

    // 물리 공격
    @TurnAct("물리 공격")
    public void PhysicalAttack(GameObject target){
        Attack physicalAttack = new PhysicalAttack(this,target);
        physicalAttack.execute();
    }

    // 마법 공격
    @TurnAct("마법 공격")
    public void MagicAttack(GameObject target){
        Attack magicAttack = new MagicAttack(this,target);
        magicAttack.execute();
    }

    // 최대 체력의 10퍼만큼 체력 회복
    @TurnAct("체력 회복")
    public void healHealth(){
        int amountHeal = Math.min( this.MaxHp, this.health + (this.MaxHp / PlayerStatEnum.PERCENT_HEAL.getStat()));;
        this.health = amountHeal;
        OutputHandler.printPlayer(this.name);
        OutputHandler.printheal(amountHeal);
    }

    @Override
    public void printStatus() {
        OutputHandler.printPlayerStats(this);
    }

    @Override
    public void objectTurn(GameObject target) {
        ActOption option = InputHandler.turnInput();
        switch (option) {
            case printStatus:
                printStatus();
                break;
            case PhysicalAttack:
                PhysicalAttack(target);
                break;
            case MagicAttack:
                MagicAttack(target);
                break;
            case healHealth:
                healHealth();
                break;
            case distributeAddStat:
                distributeAddStats();
                break;
        }
    }
}


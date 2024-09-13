package org.RPGgame.GameObject;

import org.RPGgame.Attack.Attack;
import org.RPGgame.Attack.PhysicalAttack;
import org.RPGgame.GameObject.Enum.EnemyStatEnum;
import org.RPGgame.GameObject.io.OutputHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy extends GameObject{
    private static List<Enemy> Enemys = new ArrayList<>(); // 게임에서 쓰러진 총 적

    public static int getTotalEnemy() {
        return Enemy.Enemys.size();
    }

    protected static int acc_MaxHp = EnemyStatEnum.BASE_HP.getStat();
    protected static int acc_physicalPower = EnemyStatEnum.BASE_PHYSICAL_POWER.getStat();
    protected static int acc_physicalDefense = EnemyStatEnum.BASE_PHYSICAL_DEFENSE.getStat();
    protected static int acc_magicDefense = EnemyStatEnum.BASE_MAGIC_DEFENSE.getStat();

    private final int idlePercent;

    // 점점 적이 강해짐
    public Enemy() {
        name = (Enemy.getTotalEnemy() + 1)+ "번째 적";
        Random random = new Random();
        this.MaxHp = acc_MaxHp + random.nextInt(EnemyStatEnum.BASE_HP.getStat() / EnemyStatEnum.STAT_WEIGHT.getStat());
        acc_MaxHp = MaxHp;
        this.health = MaxHp;
        this.physicalPower = acc_physicalPower + random.nextInt(EnemyStatEnum.BASE_PHYSICAL_POWER.getStat() / EnemyStatEnum.STAT_WEIGHT.getStat());
        acc_physicalPower = physicalPower;
        this.physicalDefense = acc_physicalDefense + random.nextInt(EnemyStatEnum.BASE_PHYSICAL_DEFENSE.getStat() / EnemyStatEnum.STAT_WEIGHT.getStat());
        acc_physicalDefense = physicalDefense;
        this.magicDefense = acc_magicDefense + random.nextInt(EnemyStatEnum.BASE_MAGIC_DEFENSE.getStat() / EnemyStatEnum.STAT_WEIGHT.getStat());
        acc_magicDefense = magicDefense;
        this.criticalChance = random.nextInt(100);
        this.idlePercent = random.nextInt(50);
        Enemys.add(this);
    }

    public int getMaxHp(Boolean flag){
        return Math.random() < 0.5 ? this.MaxHp : -1;
    }

    public int getHealth(Boolean flag){
        return Math.random() < 0.5 ? this.health : -1;
    }

    public int getPhysicalPower(Boolean flag){
        return Math.random() < 0.5 ? this.physicalPower : -1;
    }

    public int getPhysicalDefense(Boolean flag){
        return Math.random() < 0.5 ? this.physicalDefense : -1;
    }

    public int getMagicDefense(Boolean flag){
        return Math.random() < 0.5 ? this.magicDefense : -1;
    }

    public int getCriticalChance(Boolean flag){
        return Math.random() < 0.9 ? this.criticalChance : -1;
    }

    public int getIdlePercent(Boolean flag){
        return Math.random() < 0.9 ? this.idlePercent : -1;
    }

    public int getIdlePercent(){
        return Math.random() < 0.9 ? this.idlePercent : -1;
    }

    // 물리 공격
    @TurnAct("물리 공격")
    public void PhysicalAttack(GameObject target){
        Attack physicalAttack = new PhysicalAttack(this,target);
        physicalAttack.execute();
    }

    // 최대 체력의 5퍼만큼 체력 회복
    @TurnAct("체력 회복")
    public void healHealth(){
        int lostHealth = this.MaxHp - this.health;
        int amountHeal = Math.min( lostHealth, (this.MaxHp * EnemyStatEnum.PERCENT_HEAL.getStat() / 100));
        this.health = this.health + amountHeal;
        OutputHandler.printEnemy();
        OutputHandler.printheal(amountHeal);
    }

    @Override
    public void printStatus() {
        OutputHandler.printEnemyStats(this);
    }

    @Override
    public void objectTurn(GameObject target) {
        printStatus();

        Random random = new Random();
        int turnNum = random.nextInt(100);  // 0부터 99까지의 랜덤 숫자 생성

        // idlePercent보다 작거나 같으면 턴을 넘김
        if (turnNum <= idlePercent) {
            OutputHandler.printEnemyIdele();
            return;
        }

        // 4분의 1 확률로 체력 회복, 그렇지 않으면 물리 공격
        if (random.nextInt(4) == 0) {  // 0 ~ 3 중에서 0일 때 회복
            healHealth();  // 체력 회복
        } else {
            PhysicalAttack(target);  // 물리 공격
        }
    }
}

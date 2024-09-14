package org.RPGgame.Attack;

import org.RPGgame.Attack.Enum.AttackType;
import org.RPGgame.Attack.io.OutputHandler;
import org.RPGgame.GameObject.GameObject;

public class PhysicalAttack extends Attack{
    private final double criticalChance;

    public PhysicalAttack(GameObject attacker,GameObject attackTarget) {
        super(attacker, attackTarget);
        this.attackerName = attacker.getName();
        this.attackerTargetName = attackTarget.getName();
        this.attackType = AttackType.PHYSICAL;
        this.power = attacker.getPhysicalPower();
        this.criticalChance = attacker.getCriticalChance();
        this.defense = attackTarget.getPhysicalDefense();
    }

    @Override
    public void execute() {
        this.damage = Math.max((power - defense), 0);
        // 치명타 발생
        if (Math.random() < (double) criticalChance / 100) {
            this.damage = this.damage * 2;
        }
        attackTarget.decHp(this.damage);

        OutputHandler.printAttack(this.attackerName,this.damage,this.attackType.getStr(),this.attackerTargetName);
        OutputHandler.printTarget(attackerTargetName,this.attackTarget.getHealth());

        AttackLogList.add(this);
    }
}

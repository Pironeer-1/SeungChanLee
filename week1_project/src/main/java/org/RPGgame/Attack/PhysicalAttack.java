package org.RPGgame.Attack;

import org.RPGgame.GameObject.GameObject;

public class PhysicalAttack extends Attack{
    private final double criticalChance;

    public PhysicalAttack(GameObject attacker,GameObject attackTarget) {
        super(attacker, attackTarget);
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

        AttackLogList.add(this);
    }
}

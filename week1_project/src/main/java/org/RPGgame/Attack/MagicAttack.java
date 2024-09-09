package org.RPGgame.Attack;

import org.RPGgame.gameObject.GameObject;

public class MagicAttack extends Attack{

    public MagicAttack(GameObject attacker, GameObject attackTarget) {
        super(attacker, attackTarget);
        this.attackType = AttackType.MAGIC;
        this.power = attacker.getMagicPower();
        this.defense = attackTarget.getMagicDefense();
    }

    @Override
    Boolean execute() {
        this.damage = Math.max((power - defense), 0) * 2;
        attackTarget.decHp(this.damage);
        AttackLogList.add(this);
        return this.attackTarget.isAlive();
    }

    @Override
    void printAttackLog() {

    }
}

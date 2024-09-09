package org.RPGgame.Attack;

import org.RPGgame.GameObject.GameObject;

public class MagicAttack extends Attack{

    public MagicAttack(GameObject attacker, GameObject attackTarget) {
        super(attacker, attackTarget);
        this.attackType = AttackType.MAGIC;
        this.power = attacker.getMagicPower();
        this.defense = attackTarget.getMagicDefense();
    }

    @Override
    public void execute() {
        this.damage = Math.max((power - defense), 0) * 2;
        attackTarget.decHp(this.damage);
        AttackLogList.add(this);
    }
}

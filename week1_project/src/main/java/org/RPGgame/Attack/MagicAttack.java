package org.RPGgame.Attack;

import org.RPGgame.Attack.Enum.AttackType;
import org.RPGgame.Attack.io.OutputHandler;
import org.RPGgame.GameObject.GameObject;

public class MagicAttack extends Attack{

    public MagicAttack(GameObject attacker, GameObject attackTarget) {
        super(attacker, attackTarget);
        this.attackerName = attacker.getName();
        this.attackerTargetName = attackTarget.getName();
        this.attackType = AttackType.MAGIC;
        this.power = attacker.getMagicPower();
        this.defense = attackTarget.getMagicDefense();
    }

    @Override
    public void execute() {
        this.damage = Math.max((power - defense), 0) * 2;
        attackTarget.decHp(this.damage);
        OutputHandler.printAttack(this.attackerName,this.damage,this.attackType.getStr(),this.attackerTargetName);
        OutputHandler.printTarget(attackerTargetName,this.attackTarget.getHealth());

        AttackLogList.add(this);
    }
}

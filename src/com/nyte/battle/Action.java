package com.nyte.battle;

import com.nyte.core.Ability;

/**
 * Created by Brandon on 12/1/13.
 */
public class Action {

    private Type type;
    private Ability ability;
    private BattlingUnit target;

    public enum Type {
        ATTACK, DEFEND, ABILITY, WAIT
    }

    private Action(Type type) {
        this(type, null);
    }

    private Action(Type type, BattlingUnit target) {
        this(type, target, null);
    }

    private Action(Type type, BattlingUnit target, Ability ability) {
        this.type = type;
        this.ability = ability;
        this.target = target;
        ;
    }

    public Action createDefendAction() {
        return new Action(Type.DEFEND);
    }

    public Action createWaitAction() {
        return new Action(Type.WAIT);
    }

    public Action createAttackAction(BattlingUnit target) {
        return new Action(Type.ATTACK, target);
    }

    public Action createAbilityAction(BattlingUnit target, Ability ability) {
        return new Action(Type.ABILITY, target, ability);
    }
}

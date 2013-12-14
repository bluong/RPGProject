package com.nyte.battle;

import com.nyte.core.ability.Ability;

/**
 * Created by Brandon on 12/1/13.
 */
public class Action {

    private Type type;
    private Ability ability;
    private BattlingUnit target;

    public enum Type {
        ATTACK, DEFEND, ABILITY, WAIT, BACK;
        
        public static final String ATTACK_STRING = "Attack";
        public static final String DEFEND_STRING = "Defend";
        public static final String ABILITY_STRING = "Ability";
        public static final String WAIT_STRING = "Wait";
        public static final String BACK_STRING = "Back";
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
    }
    
    public static Action createBackAction() {
    	return new Action(Type.BACK);
    }

    public static Action createDefendAction() {
        return new Action(Type.DEFEND);
    }

    public static Action createWaitAction() {
        return new Action(Type.WAIT);
    }

    public static Action createAttackAction(BattlingUnit target) {
        return new Action(Type.ATTACK, target);
    }

    public static Action createAbilityAction(BattlingUnit target, Ability ability) {
        return new Action(Type.ABILITY, target, ability);
    }
    
    public Type getType() {
    	return type;
    }
    
    public Ability getAbility() {
    	return ability;
    }
    
    public BattlingUnit getTarget() {
    	return target;
    }
}

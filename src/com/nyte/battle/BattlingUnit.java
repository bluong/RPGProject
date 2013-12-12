package com.nyte.battle;

import com.nyte.battle.commander.ActionCommander;
import com.nyte.core.Attributes;
import com.nyte.core.Unit;

/**
 * Created by Brandon on 12/1/13.
 */
public class BattlingUnit extends Unit implements Comparable<BattlingUnit>{

    private int priority;
    private Unit beforeBattleUnit;
    private ActionCommander commander;
    private Representation representation;
    private BattlingParty battlingParty;

    public BattlingUnit(Unit unit) {
        super(unit);
        beforeBattleUnit = unit;
        priority = unit.getCurrentAttr(Attributes.Stat.DEXTERITY);
    }
    
    void setBattlingParty(BattlingParty bp) {
    	battlingParty = bp;
    }
    
    public BattlingParty getBattlingParty() {
    	return battlingParty;
    }

    @Override
    public int compareTo(BattlingUnit another) {
        return priority - another.priority;
    }

    public ActionCommander getCommander() {
        return commander;
    }
    
    public Representation getRepresentation() {
    	return representation;
    }

    public int getPriority() {
        return priority;
    }
    
    public Unit getBeforeBattleUnit() {
    	return beforeBattleUnit;
    }

    public void performAction(Action action) {
    }
}

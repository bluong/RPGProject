package com.nyte.battle;

import com.nyte.core.Attributes;
import com.nyte.core.Unit;

/**
 * Created by Brandon on 12/1/13.
 */
public class BattlingUnit extends Unit implements Comparable<BattlingUnit>{

    private int priority;
    private Unit beforeBattleUnit;
    private Commander commander;

    public BattlingUnit(Unit unit) {
        super(unit);
        beforeBattleUnit = unit;
        priority = unit.getCurrentAttr(Attributes.Stat.DEXTERITY);
    }

    @Override
    public int compareTo(BattlingUnit another) {
        return priority - another.priority;
    }

    public Commander getCommander() {
        return commander;
    }

    public int getPriority() {
        return priority;
    }

    public void performAction(Action action) {
    }
}

package com.nyte.battle;

import java.util.Iterator;
import java.util.List;

import com.nyte.core.Party;
import com.nyte.core.Target;
import com.nyte.core.Unit;

/**
 * Created by Brandon on 12/1/13.
 */
public class BattlingParty extends Target implements Iterable<BattlingUnit>{

    private Party beforeBattleParty;
    private List<BattlingUnit> units;

    public BattlingParty(Party party) {
        super();
        beforeBattleParty = party;
        for (Unit unit : party) {
        	BattlingUnit newUnit = new BattlingUnit(unit);
            units.add(newUnit);
            newUnit.setBattlingParty(this);
        }
    }

    public boolean isUnable() {
        for (BattlingUnit unit : units) {
            if (!unit.isUnable()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<BattlingUnit> iterator() {
        return units.iterator();
    }
    
    public Party getBeforeBattleParty() {
    	return beforeBattleParty;
    }
}

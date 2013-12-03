package com.nyte.battle;

import com.nyte.core.Party;
import com.nyte.core.Unit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Brandon on 12/1/13.
 */
public class BattlingParty implements Iterable<BattlingUnit>{

    private Party beforeBattleParty;
    private List<BattlingUnit> units;

    public BattlingParty(Party party) {
        super();
        beforeBattleParty = party;
        for (Unit unit : party) {
            units.add(new BattlingUnit(unit));
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
}

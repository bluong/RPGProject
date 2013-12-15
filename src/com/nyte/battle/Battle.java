package com.nyte.battle;

import com.nyte.battle.commander.ActionCommander;
import com.nyte.core.Party;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by Brandon on 11/30/13.
 */
public abstract class Battle {
	
    protected ActionCommander actionCommander;
    private BattlingParty[] opponents = new BattlingParty[2];
    private PriorityQueue<BattlingUnit> orderQueue;

    public Battle(Party p1, Party p2) {
        opponents[0] = new BattlingParty(p1);
        opponents[1] = new BattlingParty(p2);
        int totalUnitCount = p1.getUnitCount() + p2.getUnitCount();
        orderQueue = new PriorityQueue<BattlingUnit>(totalUnitCount, Collections.reverseOrder());
        for (BattlingUnit unit : opponents[0]) {
            orderQueue.add(unit);
        }
        for (BattlingUnit unit : opponents[1]) {
            orderQueue.add(unit);
        }
    }

    public void run() {
        while (!isOver()) {
            //Get next unit from queue
            BattlingUnit currentUnit = orderQueue.poll();
            Action action = actionCommander.getAction();
            currentUnit.performAction(action);
        }
    }

    private boolean isOver() {
        return opponents[0].isUnable() || opponents[1].isUnable();
    }
    
    public BattlingParty getOpposingParty(BattlingUnit unit) {
    	for (BattlingParty party : opponents) {
    		if (!party.equals(unit.getBattlingParty())) {
    			return party;
    		}
    	}
    	throw new IllegalStateException();
    }
    
    public BattlingUnit getCurrentUnit() {
    	return orderQueue.peek();
    }
}

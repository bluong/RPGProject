package com.nyte.battle.commander;

import com.nyte.battle.Action;
import com.nyte.battle.Battle;

/**
 * Created by Brandon on 12/1/13.
 */
public abstract class ActionCommander {
	
	private Battle battle;
	
	public ActionCommander(Battle b) {
		battle = b;
	}

    public abstract Action getAction();
    
    public Battle getBattle() {
    	return battle;
    }
}
